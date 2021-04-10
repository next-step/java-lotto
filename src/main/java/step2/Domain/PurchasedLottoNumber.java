package step2.Domain;

import step2.util.Parser;

public class PurchasedLottoNumber {

    private int number;

    public PurchasedLottoNumber(String number) {
        this(Parser.parseStringToInt(number));
    }

    public PurchasedLottoNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("로또 구매장수는 양수값만 입력 가능합니다.");
        }
        this.number = number;
    }

    public PurchasedLottoNumber(Money money) {
        this.number = money.getMoney() / Money.DEFAULT_LOTTO_PRICE;
    }

    public int getNumber() {
        return number;
    }
}
