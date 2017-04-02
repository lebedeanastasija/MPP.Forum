package simple.blog.app.service.exception;

public class ServiceWrongLoginException extends ServiceException {
    public ServiceWrongLoginException(){
        super();
    }

    public ServiceWrongLoginException(String message){
        super(message);
    }

    public ServiceWrongLoginException(Exception e){
        super(e);
    }

    public ServiceWrongLoginException(String message, Exception e){
        super(message, e);
    }
}
