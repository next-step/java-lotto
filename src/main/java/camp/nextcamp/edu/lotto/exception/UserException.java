package camp.nextcamp.edu.lotto.exception;

public class UserException extends RuntimeException {
	public UserException(UserExceptionMesssage message) {
		super(message.getMessage());
	}
}
