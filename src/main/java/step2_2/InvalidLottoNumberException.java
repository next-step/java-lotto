package step2_2;

public class InvalidLottoNumberException extends RuntimeException{

    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또번호는 1 이상, 45 이하여야 합니다";

    public InvalidLottoNumberException() {
        super(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }
}
