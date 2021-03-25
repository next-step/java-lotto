package step2.domain.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        Logger logger = Logger.getGlobal();
        logger.log(Level.SEVERE, String.valueOf(errorCode));
    }

    public ErrorCode errorCode(){
        return this.errorCode;
    }
}
