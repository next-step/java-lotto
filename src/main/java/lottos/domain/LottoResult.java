package lottos.domain;

public class LottoResult {

    private final LottoPrize lottoPrize;

    public LottoResult(LottoPrize lottoPrize) {
        this.lottoPrize = lottoPrize;
    }

    public LottoPrize getPrize() {
        return lottoPrize;
    }
}
