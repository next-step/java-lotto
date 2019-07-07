package lotto;

public class Money {
    private int money;
    static final int LOTTO_PRICE = 1000;

    public Money(int money) {
        this.money = money;
    }

    public int countOfBuyingLotto(){
        return this.money / LOTTO_PRICE;
    }
}
