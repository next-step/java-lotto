package lotto.exception;

public class ManualCountException extends IllegalArgumentException {

    private static final String MESSAGE = "구매할 수 있는 수량을 초과하였습니다.";

    public ManualCountException() {
        super(MESSAGE);
    }

}
