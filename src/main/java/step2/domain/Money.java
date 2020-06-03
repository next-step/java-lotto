package step2.domain;

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
