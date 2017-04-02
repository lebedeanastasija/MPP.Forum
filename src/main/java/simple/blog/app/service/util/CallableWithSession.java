package simple.blog.app.service.util;

import org.hibernate.Session;


public interface CallableWithSession<T> {
    T call(Session session) throws Exception;
}
