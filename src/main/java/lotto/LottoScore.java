package lotto;

import java.util.List;

import static lotto.LottoMatcher.*;

public class LottoScore {
    private int fourthCount = 0;
    private int thirdCount = 0;
    private int secondCount = 0;
    private int firstCount = 0;
    private int purchase;

    public LottoScore(int price, int quantity, List<LottoMatcher> lottoMatchers) {
        this.purchase = price * quantity;
        updateScore(lottoMatchers);
    }

    private void updateScore(List<LottoMatcher> lottoMatchers) {
        lottoMatchers.forEach(this::incrementScore);
    }

    private void incrementScore(LottoMatcher lottoMatcher) {
        lottoMatcher.incrementScore(this);
    }

    protected void addFirst() {
        firstCount++;
    }

    protected void addSecond() {
        secondCount++;
    }

    protected void addThird() {
        thirdCount++;
    }

    protected void addFourth() {
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

    public double rate() {
        int amount = FIRST_MATCH.amount(firstCount) +
                SECOND_MATCH.amount(secondCount) +
                THIRD_MATCH.amount(thirdCount) +
                FOURTH_MATCH.amount(fourthCount);
        return ((double) amount / purchase);
    }
}
