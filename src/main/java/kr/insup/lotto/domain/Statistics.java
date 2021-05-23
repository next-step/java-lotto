package kr.insup.lotto.domain;

import kr.insup.lotto.config.LottoConfig;

public class Statistics {

    private int firstPlace = 0;
    private int secondPlace = 0;
    private int thirdPlace = 0;
    private int fourthPlace = 0;
    private final int attempt;

    public Statistics(int attempt) {
        this.attempt = attempt;
    }

    public Statistics(int firstPlace, int secondPlace, int thirdPlace, int fourthPlace, int attempt) {
        this(attempt);
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.thirdPlace = thirdPlace;
        this.fourthPlace = fourthPlace;
    }

    public void addCountToPlace(LottoPrize lottoPrize) {
        if (lottoPrize == LottoPrize.First) {
            firstPlace++;
        }

        if (lottoPrize == LottoPrize.Second) {
            secondPlace++;
        }

        if (lottoPrize == LottoPrize.Third) {
            thirdPlace++;
        }

        if (lottoPrize == LottoPrize.Fourth) {
            fourthPlace++;
        }
    }

    public int firstPlace() {
        return firstPlace;
    }

    public int secondPlace() {
        return secondPlace;
    }

    public int thirdPlace() {
        return thirdPlace;
    }

    public int fourthPlace() {
        return fourthPlace;
    }

    public double calculateBenefitRate() {
        return (double) totalWinningPrice() / (double) (attempt * LottoConfig.LOTTO_PRICE);
    }

    private int totalWinningPrice() {
        return firstPlace * LottoPrize.First.winnings()
                + secondPlace * LottoPrize.Second.winnings()
                + thirdPlace * LottoPrize.Third.winnings() +
                +fourthPlace * LottoPrize.Fourth.winnings();
    }
}
