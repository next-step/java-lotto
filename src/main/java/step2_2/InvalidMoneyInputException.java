package step2_2;

public class InvalidMoneyInputException extends RuntimeException {

    private static final String MONEY_LESS_THAN_ZERO_MESSAGE = "돈이 음수일 수 없습니다";

    public InvalidMoneyInputException() {
        super(MONEY_LESS_THAN_ZERO_MESSAGE);
    }
}
