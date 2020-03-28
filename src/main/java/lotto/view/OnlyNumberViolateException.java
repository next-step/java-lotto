package lotto.view;

public class OnlyNumberViolateException extends IllegalArgumentException {
    public OnlyNumberViolateException() {
        super("금액은 숫자만 입력할 수 있습니다.");
    }
}
