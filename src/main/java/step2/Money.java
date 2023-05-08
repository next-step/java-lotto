package step2;

public class Money {
    private final int amount;

    Money(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 0원 이상이어야 합니다.");
        }
        this.amount = amount;
    }

    public static Money of(String amount) {
        try {
            return new Money(Integer.parseInt(amount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액은 숫자여야 합니다.");
        }
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public int getAffordableTicketCount(int ticketPrice) {
        if (ticketPrice == 0) {
            throw new IllegalArgumentException("티켓 가격은 0원 이상이어야 합니다.");
        }
        return amount / ticketPrice;
    }

    public int toIntValue() {
        return amount;
    }
}
