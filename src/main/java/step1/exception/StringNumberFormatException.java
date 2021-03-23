package step1.exception;

public class StringNumberFormatException extends RuntimeException{

    private final String message = "숫자가 아닌 문자열을 입력했습니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
