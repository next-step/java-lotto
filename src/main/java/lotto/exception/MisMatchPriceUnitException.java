package lotto.exception;

public class MisMatchPriceUnitException extends RuntimeException {
    private static final String MESSAGE = "구입할 수 있는 로또의 금액 단위는 1000원 단위 입니다.";

    public MisMatchPriceUnitException() {
        super(MESSAGE);
    }

}

