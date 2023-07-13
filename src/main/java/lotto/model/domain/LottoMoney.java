package lotto.model.domain;

public class LottoMoney {

    private static final int LOTTO_PRICE = 1_000;

    private final int value;

    private final int manualLottoCount;

    public LottoMoney(final int value, final int manualLottoCount) {
        validate(value, manualLottoCount);
        this.value = value;
        this.manualLottoCount = manualLottoCount;
    }

    private void validate(final int value, final int manualLottoCount) {
        // TODO refactor
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    "로또를 구입하기에 돈이 부족합니다. 로또는 한 장에 " + LOTTO_PRICE + "원이고, 현재 구입 금액은 "
                            + value + "원 입니다.");
        }
        if (manualLottoCount * LOTTO_PRICE > value) {
            throw new IllegalArgumentException(
                    "수동으로 구매할 수 있는 범위를 넘었습니다. 로또는 한 장에 " + LOTTO_PRICE + "원이고, 현재 구입 금액은 "
                            + value + "원 입니다. 수동으로 구매할 수 있는 장수는 " + (value / LOTTO_PRICE)
                            + "장이고, 현재 입력하신 장수는 " + manualLottoCount + "입니다.");
        }

    }

    int getValue() {
        return value;
    }

    public int getChange() {
        return value % LOTTO_PRICE;
    }

    public int getTotalCount() {
        return value / LOTTO_PRICE;
    }

    public double getTotalSpentMoney() {
        return (double) getValue() - getChange();
    }

    public int getAutoCount() {
        return getTotalCount() - manualLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
