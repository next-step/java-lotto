package step3.exception;

public class LottoNumberNullPointerException extends RuntimeException{
    private final String message = "LottoNumber 인스턴스가 null 입니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
