package simple.blog.app.DAO.transaction.impl;

import simple.blog.app.DAO.transaction.ITransactionManager;
import simple.blog.app.DAO.exception.DAOException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import simple.blog.app.persistence.HibernateUtil;
import simple.blog.app.service.util.CallableWithSession;

public class TransactionManager implements ITransactionManager {
    private static final TransactionManager instance = new TransactionManager();

    private TransactionManager() {
    }

    public static TransactionManager getInstance() {
        return instance;
    }

    @Override
    public <T> T doInTransaction(CallableWithSession<T> unitOfWork) throws DAOException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            T result = unitOfWork.call(session);

            session.getTransaction().commit();
            return result;
        } catch (Exception exception) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw new DAOException(exception);
        }
    }
}
