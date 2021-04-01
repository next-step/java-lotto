package exception;

public class ExceedSizeException extends RuntimeException{

    public ExceedSizeException(String msg){
        super(msg);
    }
}
