package domain;

public class LottoResult {
    private LottoPrizeCount lottoPrizeCount;

    public LottoResult() {
        lottoPrizeCount = new LottoPrizeCount();
    }

    public void addPrizeResult(LottoPrize lottoPrize) {
        lottoPrizeCount.incrementLottoPrize(lottoPrize);
    }

    public LottoPrizeCount getLottoPrizeCount() {
        return lottoPrizeCount;
    }

    public double calculateProfitRates() {
        Money lottoPrice = Money.of(Lotto.LOTTO_PRICE);

        int totalPrizeMoney = lottoPrizeCount.entryStream()
                                .mapToInt(e -> e.getKey().getPrizeValue() * e.getValue())
                                .sum();
        int numberOfLottos = lottoPrizeCount.entryStream()
                                .mapToInt(e -> e.getValue())
                                .sum();

        return Money.of(totalPrizeMoney).dividedBy(lottoPrice.multiply(numberOfLottos));
    }
}
