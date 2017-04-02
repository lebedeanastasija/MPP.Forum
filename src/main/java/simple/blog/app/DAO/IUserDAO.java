package simple.blog.app.DAO;

import org.hibernate.Session;
import simple.blog.app.entity.Client;
import simple.blog.app.DAO.exception.DAOException;
import simple.blog.app.entity.util.UserData;

import java.util.List;

public interface IUserDAO {

    Client createUser(Session session, UserData data) throws DAOException;

    /*void update(Client user) throws DAOException;

    void updateBanned(Client user) throws DAOException;

    void delete(int id) throws DAOException;

    Client findByLogin(String login) throws DAOException;

    Client findByIdAndRole(int id, boolean isAdmin) throws DAOException;

    List<Client> findAll(int start, int amount) throws DAOException;

    int selectUserCount() throws DAOException;*/
}
