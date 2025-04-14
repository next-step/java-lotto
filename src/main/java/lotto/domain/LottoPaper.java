package lotto.domain;

public class LottoPaper {
    public static final Integer LOTTO_PRICE = 1000;

    private final int budget;

    public LottoPaper(int budget) {
        this.budget = budget;
    }

    public int possibleTotalLottoCount() {
        return budget / LOTTO_PRICE;
    }
}
