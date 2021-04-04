package step3.exception;

public final class MapNullPointerException extends RuntimeException{

    private final String message = "Map 인스턴스가 Null 입니다.";

    @Override
    public String getMessage() {
        return message;
    }

}