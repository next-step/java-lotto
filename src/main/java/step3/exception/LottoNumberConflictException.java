package step3.exception;

public final class LottoNumberConflictException extends RuntimeException{

    private final String message = "겹치는 LottoNumber 인스턴스가 존재합니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
