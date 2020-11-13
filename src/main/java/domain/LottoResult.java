package domain;

public class LottoResult {

    private Long firstPrize = Long.valueOf(0L);
    private Long secondPrize = Long.valueOf(0L);
    private Long thirdPrize = Long.valueOf(0L);
    private Long fourthPrize = Long.valueOf(0L);
    private Double profitRates = Double.valueOf(0);

    public void checkWhetherToWin(Long countMatching) {
        if(countMatching.equals(3L)) {
            incrementFourth();
        }

        if(countMatching.equals(4L)) {
            incrementThird();
        }

        if(countMatching.equals(5L)) {
            incrementSecond();
        }

        if(countMatching.equals(6L)) {
            incrementFirst();
        }
    }

    private void incrementFirst() {
        this.firstPrize = Long.valueOf(firstPrize + 1);
    }

    private void incrementSecond() {
        this.secondPrize = Long.valueOf(secondPrize + 1);
    }

    private void incrementThird() {
        this.thirdPrize = Long.valueOf(thirdPrize + 1);
    }

    private void incrementFourth() {
        this.fourthPrize = Long.valueOf(fourthPrize + 1);
    }

    public Long getFirstPrize() {
        return firstPrize;
    }

    public Long getSecondPrize() {
        return secondPrize;
    }

    public Long getThirdPrize() {
        return thirdPrize;
    }

    public Long getFourthPrize() {
        return fourthPrize;
    }

    public Double getProfitRates() {
        return profitRates;
    }


    public void calculateProfitRates(int numberOfLottos) throws Exception {
        Money lottoPrice = Money.of(1000L);
        Money firstPrizeMoney = Money.of(2000000000L);
        Money secondPrizeMoney = Money.of(1500000L);
        Money thirdPrizeMoney = Money.of(50000L);
        Money fourthPrizeMoney = Money.of(5000L);

        Money totalPrizeMoney = firstPrizeMoney.multiply(firstPrize)
                                    .plus(secondPrizeMoney.multiply(secondPrize)
                                    .plus(thirdPrizeMoney.multiply(thirdPrize)
                                    .plus(fourthPrizeMoney.multiply(fourthPrize))));

        profitRates = totalPrizeMoney.dividedBy(lottoPrice.multiply((long) numberOfLottos));
    }
}
