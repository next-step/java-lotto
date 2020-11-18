package domain;

public class LottoResult {

    private long totalPrizeValue = 0L;
    private double profitRates = 0;
    private LottoPrizeCount lottoPrizeCount;

    public LottoResult() {
        lottoPrizeCount = new LottoPrizeCount();
    }

    public void checkWhetherToWin(Long countMatching) {
        if(LottoPrize.FOURTH_PRIZE.isWon(countMatching)) {
            incrementFourth();
        }

        if(LottoPrize.THIRD_PRIZE.isWon(countMatching)) {
            incrementThird();
        }

        if(LottoPrize.SECOND_PRIZE.isWon(countMatching)) {
            incrementSecond();
        }

        if(LottoPrize.FIRST_PRIZE.isWon(countMatching)) {
            incrementFirst();
        }
    }

    private void incrementFirst() {
        lottoPrizeCount.incrementFirst();
        totalPrizeValue += LottoPrize.FIRST_PRIZE.getPrizeValue();
    }

    private void incrementSecond() {
        lottoPrizeCount.incrementSecond();
        totalPrizeValue += LottoPrize.SECOND_PRIZE.getPrizeValue();
    }

    private void incrementThird() {
        lottoPrizeCount.incrementThird();
        totalPrizeValue += LottoPrize.THIRD_PRIZE.getPrizeValue();
    }

    private void incrementFourth() {
        lottoPrizeCount.incrementFourth();
        totalPrizeValue += LottoPrize.FOURTH_PRIZE.getPrizeValue();
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
