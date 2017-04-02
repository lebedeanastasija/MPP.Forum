package simple.blog.app.service;

import simple.blog.app.entity.Passport;
import simple.blog.app.entity.Client;
import simple.blog.app.entity.util.UserData;
import simple.blog.app.service.exception.ServiceException;

import java.util.List;


public interface IUserService {
    Client createUser(UserData data) throws ServiceException;

    /*void updateUser(Client user, Passport passport) throws ServiceException;

    void deleteUser(int id) throws ServiceException;

    void banUser(int id, boolean banned) throws ServiceException;

    Client getUserByIdAndRole(int id, boolean isAdmin) throws ServiceException;

    List<Client> getAllUsers(int start, int amount) throws ServiceException;

    int getUsersCount() throws ServiceException;*/
}
