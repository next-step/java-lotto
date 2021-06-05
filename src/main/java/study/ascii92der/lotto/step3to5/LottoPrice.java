package study.ascii92der.lotto.step3to5;

import java.util.Objects;

public class LottoPrice {

    public static final int LOTTO_PRICE = 1000;
    public static final String ERROR_MASSAGE_NOT_ENOUGH_INPUT_MONEY = "input money is not enough";
    private final int money;

    public LottoPrice(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MASSAGE_NOT_ENOUGH_INPUT_MONEY);
        }
        this.money = money;
    }

    public int lottoCount() {
        return money / LOTTO_PRICE;
    }

    public LottoPrice differenceLottoPrice(int manualLottoCount) {
        return new LottoPrice(this.money - manualLottoCount * LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrice that = (LottoPrice) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
