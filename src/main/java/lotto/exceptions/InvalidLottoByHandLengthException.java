package lotto.exceptions;

public class InvalidLottoByHandLengthException extends IllegalArgumentException {

    public static final String INVALID_LOTTO_BY_HAND_LENGTH = "수동 입력 로또의 번호 개수는 6개이어야 합니다.";
    public InvalidLottoByHandLengthException() {
        super(INVALID_LOTTO_BY_HAND_LENGTH);
    }
}
