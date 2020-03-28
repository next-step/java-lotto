package lotto.view;

public class OutOfRangeException extends IllegalArgumentException {
    public OutOfRangeException() {
        super("당첨 번호는 1~45 까지 입력할 수 있습니다.");
    }
}
