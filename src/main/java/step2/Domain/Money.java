package step2.Domain;

import step2.util.StringParser;

public class Money {

    public static final int DEFAULT_LOTTO_PRICE = 1000;
    private int money;

    public Money(String money) {
        this(StringParser.parseStringToInt(money));
    }

    public Money(int money) {
        if (money < DEFAULT_LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액을 정확히 입력해주세요");
        }
        this.money = money;
    }

    public Money remain(PurchasedLottoNumber purchasedLottoNumber) {
        int remainMoney = money - purchasedLottoNumber.getNumber() * DEFAULT_LOTTO_PRICE;
        if (remainMoney < 0) {
            throw new IllegalArgumentException("구매 금액보다 더 많은 로또를 구매 할 수 없습니다.");
        }
        return new Money(remainMoney);
    }

    public int getMoney() {
        return money;
    }
}
