package lotto.domain;

public class LottoCalculation {

    private static final int LOTTO_PRICE = 1000;
    private final Money value;

    public LottoCalculation(Money value) {
        this.value = value;
    }

    public int lottoCalculation() {
        return value.getValue() / LOTTO_PRICE;
    }

}
