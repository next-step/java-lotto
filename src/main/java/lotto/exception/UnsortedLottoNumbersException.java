package lotto.exception;

public class UnsortedLottoNumbersException extends RuntimeException {

    private static final String UNSORTED_LOTTO_NUMBERS_EXCEPTION_MESSAGE = "로또 번호는 정렬된 상태여야 합니다.";

    public UnsortedLottoNumbersException() {
        super(UNSORTED_LOTTO_NUMBERS_EXCEPTION_MESSAGE);
    }
}
