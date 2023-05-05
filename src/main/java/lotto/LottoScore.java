package lotto;

import java.util.List;

import static lotto.LottoMatcher.*;

public class LottoScore {
    private int fourthCount = 0;
    private int thirdCount = 0;
    private int secondCount = 0;
    private int firstCount = 0;
    private int purchase;

    public void updateScore(List<LottoMatcher> lottoMatchers) {
        lottoMatchers.forEach(this::incrementScore);
    }

    private void incrementScore(LottoMatcher lottoMatcher) {
        lottoMatcher.incrementScore(this);
    }

    public void addFirst() {
        firstCount++;
    }

    public void addSecond() {
        secondCount++;
    }

    public void addThird() {
        thirdCount++;
    }

    public void addFourth() {
        fourthCount++;
    }

    public int firstCount() {
        return firstCount;
    }

    public int secondCount() {
        return secondCount;
    }

    public int thirdCount() {
        return thirdCount;
    }

    public int fourthCount() {
        return fourthCount;
    }

    public void purchase(int purchase) {
        this.purchase = purchase;
    }

    public double rate() {
        int amount = FIRST_MATCH.price() * firstCount +
                SECOND_MATCH.price() * secondCount +
                THIRD_MATCH.price() * thirdCount +
                FOURTH_MATCH.price() * fourthCount;
        return ((double) amount / purchase);
    }
}
