package lotto.util;

public class MoneyLottoMapper {

    public static final int LOTTO_PRICE = 1000;

    private MoneyLottoMapper() {
    }

    public static int calculateLottoNum(int money) {
        return money / LOTTO_PRICE;
    }
}
