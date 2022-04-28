package lotto.exception;

public class InvalidLottoWinnerTypeException extends RuntimeException {
    private static final String MESSGAE = "유효하지 않은 로또 당참 타입입니다.";

    public InvalidLottoWinnerTypeException() {
        super(String.format(MESSGAE));
    }
}
