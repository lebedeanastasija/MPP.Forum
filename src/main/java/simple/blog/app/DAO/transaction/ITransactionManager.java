package simple.blog.app.DAO.transaction;

import simple.blog.app.DAO.exception.DAOException;
import simple.blog.app.service.util.CallableWithSession;

public interface ITransactionManager {
    <T> T doInTransaction(CallableWithSession<T> unitOfWork) throws DAOException;
}
