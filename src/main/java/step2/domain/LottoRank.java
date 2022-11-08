package step2.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {

    MISS(0, 0),
    WINNING_THREE_NUMBER(3, 5000),
    WINNING_FOUR_NUMBER(4, 50000),
    WINNING_FIVE_NUMBER(5, 1500000),
    WINNING_SIX_NUMBER(6, 2000000000);

    private final int countOfMatchNumber;
    private final int reward;

    LottoRank(int countOfMatchNumber, int reward) {
        this.reward = reward;
        this.countOfMatchNumber = countOfMatchNumber;
    }

    public static LottoRank countOfMatchNumber(Integer countOfMatchNumber) {
        return Arrays.stream(values())
                .filter(LottoRank -> LottoRank.countOfMatchNumber == countOfMatchNumber)
                .findAny()
                .orElse(MISS);
    }

    public static double getYield(List<LottoRank> lottoRanks, PurchasePrice purchasePrice) {
        return Math.round((double) lottoRanks.stream()
                .mapToInt(LottoRank::getReward)
                .sum() / purchasePrice.getPurchasePrice() * 100) / 100.0;
    }

    public int getReward() {
        return reward;
    }

    public int getCountOfMatchNumber() {
        return countOfMatchNumber;
    }

    public int getCountOfLottoRanks(List<LottoRank> lottoRanks) {
        return (int) lottoRanks.stream()
                .filter(lottoRank -> this == lottoRank)
                .count();
    }
}
