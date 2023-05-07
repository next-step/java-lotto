package lotto.domain;

public class Result {
    private Purchase purchase;
    private int rankFirstCount;
    private int rankSecondCount;
    private int rankThirdCount;
    private int rankFourthCount;
    private int prizeAmount;

    public Result(Purchase purchase) {
        this.purchase = purchase;
    }

    public void update(int matchingCount) {
        if (matchingCount == LottoRule.MATCH_COUNT_FOR_RANK_FOURTH) {
            rankFourthCount++;
            return;
        }
        if (matchingCount == LottoRule.MATCH_COUNT_FOR_RANK_THIRD) {
            rankThirdCount++;
            return;
        }
        if (matchingCount == LottoRule.MATCH_COUNT_FOR_RANK_SECOND) {
            rankSecondCount++;
            return;
        }
        if (matchingCount == LottoRule.MATCH_COUNT_FOR_RANK_FIRST) {
            rankFirstCount++;
        }
    }

    public void sumPrizeAmount() {
        prizeAmount += rankFourthCount * LottoRule.RANK_FOURTH_PRIZE;
        prizeAmount += rankThirdCount * LottoRule.RANK_THIRD_PRIZE;
        prizeAmount += rankSecondCount * LottoRule.RANK_SECOND_PRIZE;
        prizeAmount += rankFirstCount * LottoRule.RANK_FIRST_PRIZE;
    }

    public int rankFourthCount() {
        return rankFourthCount;
    }

    public int rankThirdCount() {
        return rankThirdCount;
    }

    public int rankSecondCount() {
        return rankSecondCount;
    }

    public int rankFirstCount() {
        return rankFirstCount;
    }

    public double profit() {
        return (prizeAmount + 0.0) / (purchase.money());
    }
}
