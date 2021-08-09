package calculator;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String s) {
        super(s);
    }
}
