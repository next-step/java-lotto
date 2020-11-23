package exception;

public class OutOfLottoManualCountException extends IllegalArgumentException{
    private static final String MESSAGE = "수동 로또의 수는 0 이상, 구매할 수 있는 로또 수 사이여야 합니다.";
    public OutOfLottoManualCountException() {
        super(MESSAGE);
    }
}
