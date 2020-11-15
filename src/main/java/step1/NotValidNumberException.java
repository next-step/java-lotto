package step1;

public class NotValidNumberException extends RuntimeException{

    private static final String MESSAGE = "올바른 숫자형식이 아닙니다.";

    public NotValidNumberException(){
        super(MESSAGE);
    }

}
