package step2.Domain;

import step2.Validation.StringValidator;

public class Money {

    public static final int DEFAULT_LOTTO_PRICE = 1000;
    private int money;

    public Money(String money) {
        this(StringValidator.parseStringToInt(money));
    }

    public Money(int money) {
        if (money < DEFAULT_LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액을 정확히 입력해주세요");
        }
        this.money = money;
    }

    public Money remain(PurchasedLottoNumber purchasedLottoNumber){
        return new Money(money - purchasedLottoNumber.getNumber() * DEFAULT_LOTTO_PRICE);
    }

    public int getMoney() {
        return money;
    }
}
