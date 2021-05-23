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

    public void addCountToPlace(Place place) {
        if (place == Place.First) {
            firstPlace++;
        }
        if (place == Place.Second) {
            secondPlace++;
        }
        if (place == Place.Third) {
            thirdPlace++;
        }
        if (place == Place.Fourth) {
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
        return firstPlace * Place.First.winnings()
                + secondPlace * Place.Second.winnings()
                + thirdPlace * Place.Third.winnings() +
                +fourthPlace * Place.Fourth.winnings();
    }
}
