package step2;

public class NotPositiveNumberException extends RuntimeException{
    public static final String CHARACTER_OR_NEGATIVE_NUMBER_ERROR = "문자와 음수는 입력이 불가능 합니다.";

    public NotPositiveNumberException() {
        super(CHARACTER_OR_NEGATIVE_NUMBER_ERROR);
    }

    public NotPositiveNumberException(String message){
        super(message);
    }
}
