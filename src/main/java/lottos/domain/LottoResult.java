package lottos.domain;

public class LottoResult {

    private final LottoPrize lottoPrize;

    public LottoResult(final LottoPrize lottoPrize) {
        this.lottoPrize = lottoPrize;
    }

    public LottoPrize getPrize() {
        return lottoPrize;
    }
}
