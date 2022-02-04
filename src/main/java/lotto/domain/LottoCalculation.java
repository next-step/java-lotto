package lotto.domain;

public class LottoCalculation {

    private final Money value;
    private static final int LOTTO_PRICE = 1000;

    public LottoCalculation(Money value) {
        this.value = value;
    }

    public int lottoCalculation() {
        return value.getValue() / LOTTO_PRICE;
    }

}
