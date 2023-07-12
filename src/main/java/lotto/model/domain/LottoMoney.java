package lotto.model.domain;

public class LottoMoney {

    private static final int LOTTO_PRICE = 1_000;

    private final int value;

    public LottoMoney(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    "로또를 구입하기에 돈이 부족합니다. 로또는 한 장에 " + LOTTO_PRICE + "원 입니다. 현재 구입 금액은 "
                            + value + "원 입니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public int getChange() {
        return value % LOTTO_PRICE;
    }

    public int getCount() {
        return value / LOTTO_PRICE;
    }

    public double getSpentMoney() {
        return (double) getValue() - getChange();
    }
}
