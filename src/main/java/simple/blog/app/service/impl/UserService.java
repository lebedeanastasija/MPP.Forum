package simple.blog.app.service.impl;

import com.sun.deploy.util.SessionState;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simple.blog.app.DAO.transaction.impl.TransactionManager;
import simple.blog.app.entity.util.UserData;
import simple.blog.app.persistence.HibernateUtil;
import simple.blog.app.service.IUserService;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import  simple.blog.app.entity.Passport;
import  simple.blog.app.entity.Client;
//import  simple.blog.app.DAO.PassportDAO;
import  simple.blog.app.DAO.impl.UserDAO;
import  simple.blog.app.DAO.exception.DAOException;

//import  simple.blog.app.DAO.transaction.TransactionManager;

import  simple.blog.app.service.impl.UserService;

import  simple.blog.app.service.exception.ServiceException;
import  simple.blog.app.service.exception.ServiceWrongLoginException;
import  simple.blog.app.service.exception.ServiceWrongPasswordException;
import simple.blog.app.service.util.CallableWithSession;
import  simple.blog.app.service.util.PasswordHelper;
import  simple.blog.app.service.util.Validator;

import java.util.List;
import java.util.Observable;

@Service("UserService")
public class UserService implements IUserService {
    private static final Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserDAO userDAO;

    /*@Override
    public ClientEntity getUserByIdAndRole(int id, boolean isAdmin) throws ServiceException {
        if (!Validator.validateInt(id)) {
            throw new ServiceException("Wrong id for getting user");
        }
        try {
            ClientEntity user = transactionManager.doInTransaction((Session s) -> {
                userDAO.findByIdAndRole(id, isAdmin, s);
            });
            if (user != null) {
                PassportEntity passport = transactionManager.doInTransaction(() -> passportDAO.findById(user.getPassport().getId()));
                user.setPassport(passport);
            }
            return user;
        } catch (DAOException e) {
            logger.error(e);
            throw new ServiceException("Service layer: cannot get user by id", e);
        }
    }*/

    /*@Override
    public void updateUser(ClientEntity user, PassportEntity passport) throws ServiceException {
        if (!Validator.validateLogin(user.getLogin())) {
            throw new ServiceWrongLoginException("Wrong login");
        }
        if (!Validator.validatePassword(user.getPassword())) {
            throw new ServiceWrongPasswordException("Wrong password");
        }
        if (!Validator.validatePassportIdNumber(passport.getIdentificationNumber()) ||
                !Validator.validatePassportSeries(passport.getSeries()) ||
                !Validator.validateName(passport.getSurname()) ||
                !Validator.validateName(passport.getName()) ||
                !Validator.validateName(passport.getPatronymic()) ||
                !Validator.validateBirthdayDate(passport.getBirthday())) {
            throw new ServiceException("Wrong parameters for updating user");
        }

        byte[] encryptPassword = PasswordHelper.getInstance().encryptPassword(user.getPassword());

        try {
            User userWithThisId = transactionManager.doInTransaction(() -> userDAO.findByIdAndRole(user.getId(), false));
            User userWithThisLogin = transactionManager.doInTransaction(() -> userDAO.findByLogin(user.getLogin()));

            if (userWithThisLogin != null && userWithThisLogin.getId() != user.getId()) {
                throw new ServiceWrongLoginException("Wrong login");
            }

            user.setPassword(encryptPassword);

            transactionManager.doInTransaction(() -> {
                userDAO.update(user);

                passport.setId(userWithThisId.getPassport().getId());

                passportDAO.update(passport);
                return Optional.empty();
            });
        } catch (DAOException e) {
            logger.error(e);
            throw new ServiceException("Service layer: cannot make a registration", e);
        } finally {
            PasswordHelper.dispose(encryptPassword);
        }
    }*/

    /*@Override
    public List<User> getAllUsers(int start, int amount) throws ServiceException {
        try {
            return transactionManager.doInTransaction(() -> {
                List<User> users = userDAO.findAll(start, amount);
                for (User user : users) {
                    Passport passport = passportDAO.findById(user.getPassport().getId());
                    user.setPassport(passport);
                }
                return users;
            });
        } catch (DAOException e) {
            logger.error(e);
            throw new ServiceException("Service layer: cannot get all users", e);
        }
    }*/

    /*@Override
    public void banUser(int id, boolean banned) throws ServiceException {
        if (!Validator.validateInt(id)) {
            throw new ServiceException("Wrong parameters for ban user");
        }

        User user = new User();
        user.setId(id);
        user.setBanned(banned);

        this.service("Service layer: cannot ban user",
                () -> {
                    userDAO.updateBanned(user);
                    return Optional.empty();
                }
        );
    }*/

    /*@Override
    public void deleteUser(int id) throws ServiceException {
        if (!Validator.validateInt(id)) {
            throw new ServiceException("Wrong id for deleting user");
        }

        this.service("Service layer: cannot delete user",
                () -> {
                    User user = userDAO.findByIdAndRole(id, false);
                    userDAO.delete(id);
                    passportDAO.delete(user.getPassport().getId());
                    return Optional.empty();
                }
        );
    }*/

    /*@Override
    public int getUsersCount() throws ServiceException {
        return this.service("Service layer: cannot get count of users",
                userDAO::selectUserCount
        );
    }*/

    @Override
    public Client createUser(UserData data) throws ServiceException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Client user = userDAO.createUser(session, data);
            session.getTransaction().commit();
            return user;
        } catch (DAOException exception) {
            session.getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    /*try {
            ClientEntity user = transactionManager.doInTransaction((Session s) -> {
                userDAO.findByIdAndRole(id, isAdmin, s);
            });
            if (user != null) {
                PassportEntity passport = transactionManager.doInTransaction(() -> passportDAO.findById(user.getPassport().getId()));
                user.setPassport(passport);
            }
            return user;
        } catch (DAOException e) {
            logger.error(e);
            throw new ServiceException("Service layer: cannot get user by id", e);
        }
    */
}

