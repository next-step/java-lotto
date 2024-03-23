package lotto.error;

public enum ErrorMessage {

    SIZE_EXCEED_LOTTO_NUMBER("로또 번호는 1부터 45의 범위만 가능합니다."),
    SIZE_EXCEED_LOTTO("로또의 사이즈는 최대 6입니다.");

    ErrorMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
