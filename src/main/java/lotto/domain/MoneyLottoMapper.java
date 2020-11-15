package lotto.domain;

public class MoneyLottoMapper {

    private static final int LOTTO_PRICE = 1000;

    private MoneyLottoMapper() {
    }

    public static int calculateLottoNum(int money) {
        return money / LOTTO_PRICE;
    }
}
