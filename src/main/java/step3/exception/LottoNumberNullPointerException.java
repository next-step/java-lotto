package step3.exception;

public final class LottoNumberNullPointerException extends RuntimeException{

    private final String message = "LottoNumber 인스턴스가 null 입니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
