package lotto.exception;

public class InvalidLottoNumberCount extends IllegalArgumentException {

    private static final String MESSAGE = "로또번호는 6개를 가져야합니다.";

    public InvalidLottoNumberCount() {
        super(MESSAGE);
    }
}
