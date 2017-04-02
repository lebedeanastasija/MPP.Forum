package simple.blog.app.DAO.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import simple.blog.app.DAO.IUserDAO;
import simple.blog.app.entity.Passport;
import simple.blog.app.entity.Client;
import simple.blog.app.DAO.impl.UserDAO;
import simple.blog.app.DAO.exception.DAOException;
import simple.blog.app.DAO.transaction.impl.TransactionManager;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.format.TextStyle;
import org.apache.xerces.impl.dv.util.Base64;
import simple.blog.app.entity.util.UserData;

import java.util.*;

@Component
public class UserDAO implements IUserDAO {

    /*@Override
    public void insert(ClientEntity user, Session session) throws DAOException{

    }*/

   /* @Override
    public void update(User user) throws DAOException {
        doDataManipulation(dataSource, UPDATE_USER_QUERY, "DAO layer: cannot update user",
                preparedStatement -> {
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setString(2, Base64.encode(user.getPassword()));
                    preparedStatement.setInt(3, user.getId());
                }
        );
    }

    @Override
    public void updateBanned(User user) throws DAOException {
        doDataManipulation(dataSource, UPDATE_BANNED_USER_QUERY, "DAO layer: cannot update banned user",
                preparedStatement -> {
                    preparedStatement.setBoolean(1, user.isBanned());
                    preparedStatement.setInt(2, user.getId());
                }
        );
    }

    @Override
    public void delete(int id) throws DAOException {
        doDataManipulation(dataSource, DELETE_USER_BY_ID_QUERY, "DAO layer: cannot delete user",
                preparedStatement -> preparedStatement.setInt(1, id)
        );
    }

    @Override
    public User findByLogin(String login) throws DAOException {
        PreparedStatement preparedStatementAdministrator = null;
        ResultSet resultSetAdministrator = null;
        PreparedStatement preparedStatementClient = null;
        ResultSet resultSetClient = null;
        User user = null;
        try{
            Connection connection = dataSource.getConnection();
            preparedStatementAdministrator = connection.prepareStatement(SELECT_ADMINISTRATOR_BY_LOGIN_QUERY);

            preparedStatementAdministrator.setString(1, login);
            resultSetAdministrator = preparedStatementAdministrator.executeQuery();

            if(!resultSetAdministrator.next()){
                preparedStatementClient = connection.prepareStatement(SELECT_CLIENT_BY_LOGIN_QUERY);

                preparedStatementClient.setString(1, login);
                resultSetClient = preparedStatementClient.executeQuery();

                if(resultSetClient.next()){
                    user = new User();
                    user.setId(resultSetClient.getInt(1));
                    user.setLogin(resultSetClient.getString(2));
                    user.setPassword(Base64.decode(resultSetClient.getString(3)));
                    user.setBanned(resultSetClient.getBoolean(5));
                    user.setAdmin(false);
                }
            }
            else{
                user = new User();
                user.setId(resultSetAdministrator.getInt(1));
                user.setLogin(resultSetAdministrator.getString(2));
                user.setPassword(Base64.decode(resultSetAdministrator.getString(3)));
                user.setAdmin(true);
            }

        }  catch (SQLException e){
            logger.error(e);
            throw new DAOException("DAO layer: cannot find user by login", e);
        } finally {
            close(resultSetAdministrator, preparedStatementAdministrator, resultSetClient, preparedStatementClient);
        }

        return user;
    }

    @Override
    public User findByIdAndRole(int id, boolean isAdmin) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try{
            Connection connection = dataSource.getConnection();
            if (isAdmin){
                preparedStatement = connection.prepareStatement(SELECT_ADMINISTRATOR_BY_ID_QUERY);
            } else {
                preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID_QUERY);
            }

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                Passport passport = new Passport();
                passport.setId(resultSet.getInt(4));
                user.setPassport(passport);
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(Base64.decode(resultSet.getString(3)));
                if (!isAdmin) {
                    user.setBanned(resultSet.getBoolean(5));
                    user.setVisitsNumber(resultSet.getInt(6));
                }
            }

        }  catch (SQLException e){
            logger.error(e);

            throw new DAOException("DAO layer: cannot find user by id", e);
        } finally {
            close(resultSet, preparedStatement);
        }

        return user;
    }

    @Override
    public List<User> findAll(int start, int amount) throws DAOException {
        return select(dataSource, SELECT_ALL_CLIENTS_QUERY, "DAO layer: cannot select all users",
                preparedStatement -> {
                    preparedStatement.setInt(1, start);
                    preparedStatement.setInt(2, amount);
                },
                this :: createUser
        );
    }

    @Override
    public int selectUserCount() throws DAOException {
        return this.singleSelect(
                dataSource,
                SELECT_COUNT_OF_USERS,
                "Can't get count of users",
                resultSet -> {
                    resultSet.next();
                    return resultSet.getInt(1);
                }
        );
    }*/

    @Override
    public Client createUser(Session session, UserData data) throws DAOException {
        try {
            Client user = new Client();
            user.setLogin(data.getLogin());
            user.setPassword(data.getPassword());
            user.setBanned((byte)0);
            user.setIdClient(0);

            Passport passport = new Passport();
            passport.setBirthday(data.getBirthday());
            passport.setName(data.getName());
            passport.setSurname(data.getSurname());
            passport.setPatronymic(data.getPatronymic());
            passport.setPassportNumber(data.getPassportNumber());
            passport.setSeries(data.getSeries());
            passport.setIdPassport(0);
            session.save(passport);
            Passport new_passport = (Passport)session.createCriteria(Passport.class).add(Restrictions.and(Restrictions.eq("passportNumber", data.getPassportNumber()),Restrictions.eq("series", data.getSeries()))).uniqueResult();

            user.setIdPassport(new_passport.getIdPassport());
            session.save(user);

            return user;
        } catch(Exception exception) {
            throw new DAOException(exception);
        }
    }
}
