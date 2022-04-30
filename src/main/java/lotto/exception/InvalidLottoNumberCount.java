package lotto.exception;

public class InvalidLottoNumberCount extends IllegalArgumentException {

    private static final String MESSAGE = "로또는 6개의 로또번호를 가져야합니다.";

    public InvalidLottoNumberCount() {
        super(MESSAGE);
    }

    public InvalidLottoNumberCount(String message) {
        super(message);
    }
}
