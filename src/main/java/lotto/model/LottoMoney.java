package lotto.model;

public class LottoMoney {
    private static final int LOTTO_UNIT = 1000;
    private static final int ZERO = 0;
    private int money;

    public LottoMoney(final int money) {
        validateMoney(money);
        this.money = money;
    }

    public LottoMoney(final ManualLottoCount manualLottoCount) {
        this.money = manualLottoCount.getManualCount() * LOTTO_UNIT;
    }

    private void validateMoney(final int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException("로또 머니가 양수여야 합니다.");
        }
        if (money % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException("로또는 천원 단위입니다.");
        }
    }

    public LottoMoney consume(final ManualLottoCount manualLottoCount) {
        int spentMoney = this.money - manualLottoCount.getManualCount() * LOTTO_UNIT;
        validateSpentMoney(spentMoney);
        return new LottoMoney(spentMoney);
    }

    private void validateSpentMoney(final int spentMoney) {
        if (spentMoney < ZERO) {
            throw new IllegalStateException("가지고 있는 금액보다 더 많은 로또를 구매할 수 없습니다.");
        }
    }

    public int getMoney() {
        return money;
    }

    public int getLottoCount() {
        return money / LOTTO_UNIT;
    }
}
