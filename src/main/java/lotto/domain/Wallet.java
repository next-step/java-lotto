package lotto.domain;

import static utils.IntegerValidator.getNumberIfPositive;

public class Wallet {

    private final int money;

    public Wallet(int money) {
        this.money = getNumberIfPositive(money);
    }

    public int getNumberOfBuyAvailableLottoTicket() {
        return money / LottoTicket.PRICE;
    }
}
