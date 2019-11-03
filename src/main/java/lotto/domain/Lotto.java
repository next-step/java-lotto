package lotto.domain;

public class Lotto {

    private static final int LOTTO_AMOUNT = 1000;

    public int buyTicket(int amount) {
        return amount/LOTTO_AMOUNT;
    }
}
