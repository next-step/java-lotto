package my.project.lotto.domain;

/**
 * Created : 2020-11-23 오후 12:10
 * Developer : Seo
 */
public class Money {
    public static final int PRICE = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("구입금액은 " + PRICE + "원 이상입니다.");
        }
    }

    public int getChances() {
        return this.money / PRICE;
    }
}
