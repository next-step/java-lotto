package domain;

public class LottoResult {

    private Long firstPrizeCount = Long.valueOf(0L);
    private Long secondPrizeCount = Long.valueOf(0L);
    private Long thirdPrizeCount = Long.valueOf(0L);
    private Long fourthPrizeCount = Long.valueOf(0L);

    private Long totalPrizeValue = Long.valueOf(0L);
    private Double profitRates = Double.valueOf(0);

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
        this.firstPrizeCount = Long.valueOf(firstPrizeCount + 1);
        totalPrizeValue += LottoPrize.FIRST_PRIZE.getPrizeValue();
    }

    private void incrementSecond() {
        this.secondPrizeCount = Long.valueOf(secondPrizeCount + 1);
        totalPrizeValue += LottoPrize.SECOND_PRIZE.getPrizeValue();
    }

    private void incrementThird() {
        this.thirdPrizeCount = Long.valueOf(thirdPrizeCount + 1);
        totalPrizeValue += LottoPrize.THIRD_PRIZE.getPrizeValue();
    }

    private void incrementFourth() {
        this.fourthPrizeCount = Long.valueOf(fourthPrizeCount + 1);
        totalPrizeValue = LottoPrize.FOURTH_PRIZE.getPrizeValue();
    }

    public Long getFirstPrizeCount() {
        return firstPrizeCount;
    }

    public Long getSecondPrizeCount() {
        return secondPrizeCount;
    }

    public Long getThirdPrizeCount() {
        return thirdPrizeCount;
    }

    public Long getFourthPrizeCount() {
        return fourthPrizeCount;
    }

    public Double getProfitRates() {
        return profitRates;
    }

    public void calculateProfitRates(int numberOfLottos) throws Exception {
        Money lottoPrice = Money.of(1000L);
        Money totalPrizeMoney = Money.of(totalPrizeValue);

        profitRates = totalPrizeMoney.dividedBy(lottoPrice.multiply((long) numberOfLottos));
    }
}
