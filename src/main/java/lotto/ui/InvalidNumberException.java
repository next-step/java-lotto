package lotto.ui;

public class InvalidNumberException extends IllegalArgumentException {
    public InvalidNumberException() {
        super("번호는 숫자만 입력할 수 있습니다.");
    }
}
