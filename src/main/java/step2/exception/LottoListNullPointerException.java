package step2.exception;

public class LottoListNullPointerException extends RuntimeException{
    private final String message = "LottoList 인스턴스가 null 입니다.";

    @Override
    public String getMessage() {
        return message;
    }
}
