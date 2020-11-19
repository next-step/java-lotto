package domain;

public class LottoResult {
    private int totalPrizeValue = 0;
    private double profitRates = 0;
    private LottoPrizeCount lottoPrizeCount;

    public LottoResult() {
        lottoPrizeCount = new LottoPrizeCount();
    }

    public void addPrizeResult(LottoPrize lottoPrize) {
        lottoPrizeCount.incrementLottoPrize(lottoPrize);
        totalPrizeValue += lottoPrize.getPrizeValue();
    }

    public Double getProfitRates() {
        return profitRates;
    }

    public LottoPrizeCount getLottoPrizeCount() {
        return lottoPrizeCount;
    }

    public void calculateProfitRates(int numberOfLottos) throws Exception {
        Money lottoPrice = Money.of(1_000L);
        Money totalPrizeMoney = Money.of(totalPrizeValue);

        profitRates = totalPrizeMoney.dividedBy(lottoPrice.multiply((long) numberOfLottos));
    }
}
