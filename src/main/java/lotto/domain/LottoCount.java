package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class LottoCount {

    private final long value;

    public LottoCount(final long value) {
        validateValueRange(value);
        this.value = value;
    }

    private void validateValueRange(final long value) {
        if (value <= 0) {
            throw new IllegalArgumentException("수동 로또 개수는 양의 정수여야 합니다.");
        }
    }

    public LottoMoney toTotalLottoPrice() {
        return new LottoMoney(value * LOTTO_PRICE);
    }

    public long getValue() {
        return value;
    }
}
