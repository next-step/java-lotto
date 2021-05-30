package step5.domain;

import step5.exception.NotEnoughInitManualMoneyException;

public class ManualNumber {

    private static final int ONE_LOTTO_PRICE = 1000;
    private int manualNumber;

    public ManualNumber(Money money, int number) {
        checkEnoughMoney(money,number);
        money.minus(new Money(number * ONE_LOTTO_PRICE));

        this.manualNumber = number;
    }

    private void checkEnoughMoney(Money money, int number) {
        if(money.getCurrentMoney() < number *  ONE_LOTTO_PRICE) {
            throw new NotEnoughInitManualMoneyException();
        }
    }

    public boolean moreThanZero() {
        return manualNumber > 0;
    }

    public void minus() {
        this.manualNumber--;
    }
}
