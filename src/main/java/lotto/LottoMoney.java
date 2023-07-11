package lotto;

public class LottoMoney {

    private final int value;

    public LottoMoney(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < 1_000) {
            throw new IllegalArgumentException("로또를 구입하기에 돈이 부족합니다. 로또는 한 장에 1000원 입니다. 현재 구입 금액은 " + value + "원 입니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
