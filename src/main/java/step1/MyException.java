package step1;

public enum  MyException {

    INVALID_NUMBER("0 이상의 정수값만 입력해주세요"),
    ;

    private String message;

    MyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
