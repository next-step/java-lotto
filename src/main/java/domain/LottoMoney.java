package domain;

public class LottoMoney {
    private static final Integer LOTTO_PRICE = 1_000;
    private static final Integer MINIMUM_PRICE = LOTTO_PRICE * 1;
    private static final Integer MAXIMUM_PRICE = LOTTO_PRICE * 100;

    private final Integer money;

    public LottoMoney(Integer money) {
        validateLottoMoney(money);
        this.money = money;
    }

    public Integer getLottoCount() {
        return money / LOTTO_PRICE;
    }

    private void validateLottoMoney(Integer money) {
        validateLottoMoneyUnit(money);
        validateLottoMoneyRange(money);
    }

    private void validateLottoMoneyUnit(Integer money) {
        if(money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoMoneyRange(Integer money) {
        if(money < MINIMUM_PRICE) {
            throw new IllegalArgumentException();
        }

        if(money > MAXIMUM_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public Double calculateProfitRate(Long prizeMoney) {
        return prizeMoney.doubleValue() / money.doubleValue();
    }
}
