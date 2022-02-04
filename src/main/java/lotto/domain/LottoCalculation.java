package lotto.domain;

public class LottoCalculation {

    private final int value;
    private static final int LOTTO_PRICE = 1000;

    public LottoCalculation(int value) {
        this.value = value;
    }

    public int lottoCalculation() {
        return (int)this.value/LOTTO_PRICE;
    }

}
