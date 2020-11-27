package lotto.automatic.domain;

public class LottoMoney {

    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public LottoMoney(int money) {

        validate(money);
        this.money = money;

    }

    private void validate(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("금액이 모자랍니다.");
        }
    }

    public int getCountOfLotto() {

        return (money / LOTTO_PRICE);
    }

    public float calculateEarningRate(long earningMoney) {

        return (float) earningMoney / money;

    }

}
