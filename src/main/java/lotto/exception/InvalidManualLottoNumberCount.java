package lotto.exception;

public class InvalidManualLottoNumberCount extends IllegalArgumentException {

    private static final String MESSAGE = "수동 로또 번호 개수가 총 로또 개수(%d)를 초과할 수 없습니다.";

    public InvalidManualLottoNumberCount(int totalLottoCount) {
        super(String.format(MESSAGE, totalLottoCount));
    }
}
