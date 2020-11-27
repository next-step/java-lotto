package my.project.lotto.domain;

/**
 * Created : 2020-11-23 오후 12:10
 * Developer : Seo
 */
public class Money {
    public static final int PRICE = 1000;
    public static final int FIRST_PRICE = 2_000_000_000;
    public static final int THIRD_PRICE = 1_500_000;
    public static final int FOURTH_PRICE = 50_000;
    public static final int FIFTH_PRICE = 5_000;
    private final int money;

    public Money(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("구입금액은 " + PRICE + "원 이상입니다.");
        }
        this.money = money;
    }

    public int getChances() {
        return this.money / PRICE;
    }
}
