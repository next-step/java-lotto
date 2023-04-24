package lotto.Model;

public class Count {
    private static final int AMOUNT_OF_TICKET = 1000;

    private final int countOfTicket;

    public Count(int amount) {
        this.countOfTicket = countTicket(amount);
    }

    public static int countTicket(int amount) {
        if (amount % AMOUNT_OF_TICKET != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 "+AMOUNT_OF_TICKET+"원 단위로 가능합니다.");
        }

        return amount / AMOUNT_OF_TICKET;
    }

    public int value() {
        return countOfTicket;
    }
}
