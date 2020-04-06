package lotto.ui;

public class InvalidMoneyException extends IllegalArgumentException {
    public InvalidMoneyException() {
        super("금액은 숫자만 입력할 수 있습니다.");
    }
}
