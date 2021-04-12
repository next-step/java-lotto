package lotto.exception;

public class NumberAlreadyExistsException extends RuntimeException {

    public NumberAlreadyExistsException(){
        super("Number already exists.");
    }

    public NumberAlreadyExistsException(String s) {
        super(s);
    }
}
