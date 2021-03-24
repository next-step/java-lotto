package step2.domain.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomException extends RuntimeException {

    public CustomException(ErrorCode errorCode) {
        Logger logger = Logger.getGlobal();
        logger.log(Level.SEVERE, errorCode.toString());
    }
}
