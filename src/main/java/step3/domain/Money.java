package step3.domain;

/*
 * Lotto
 * Money
 * ver. 1.0
 * 2020.05.31
 */
public class Money {

    private int payedMoney;

    public Money(String input) {
        Number.checkNumber(input);
        Number.checkNotNumber(input);
        this.payedMoney = Integer.parseInt(input);
    }

    public int getPayedMoney() {
        return payedMoney;
    }

}
