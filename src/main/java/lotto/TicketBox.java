package lotto;

public class TicketBox {

    public static final String ERROR_AMOUNT_CANNOT_BE_DIVIDED = "로또 가격으로 정확히 나누어떨어지는 금액을 입력해주세요.";
    public static final String ERROR_AMOUNT_OUT_OF_RANGE = "1천원 이상, 10만원 이하의 금액을 입력해주세요.";

    public static final int PRICE_PER_TICKET = 1000;
    public static final int MINIMUM_PURCHASE_AMOUNT = 1000;
    public static final int MAXIMUM_PURCHASE_AMOUNT = 100000;


    public int issueTicket(int amount) {
        checkValidInput(amount);
        checkDividable(amount);
        return amount / PRICE_PER_TICKET;
    }

    private void checkValidInput(int amount) throws IllegalArgumentException {
        if (amount < MINIMUM_PURCHASE_AMOUNT
                || amount > MAXIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ERROR_AMOUNT_OUT_OF_RANGE);
        }
    }

    private void checkDividable(int amount) throws ArithmeticException {
        if (amount % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException(ERROR_AMOUNT_CANNOT_BE_DIVIDED);
        }
    }
}
