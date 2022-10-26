package step2.lottoGame.dto;

import step2.lotto.Rank;

import java.util.Map;

public class RankValue {

    private final long numberOfWinnings;
    private final double prizeAmount;
    private final long numberOfMatchingNumbers;

    public RankValue(long numberOfWinnings, double prizeAmount, long numberOfMatchingNumbers) {
        this.numberOfWinnings = numberOfWinnings;
        this.prizeAmount = prizeAmount;
        this.numberOfMatchingNumbers = numberOfMatchingNumbers;
    }

    public static RankValue from(Map.Entry<Rank, Long> entry) {
        Rank rank = entry.getKey();
        Long countOfNumber = entry.getValue();
        return new RankValue(countOfNumber, rank.prizeAmount(), rank.numberOfMatchingNumbers());
    }

    public long numberOfWinnings() {
        return numberOfWinnings;
    }

    public long prizeAmount() {
        return (long) prizeAmount;
    }

    public long numberOfMatchingNumbers() {
        return numberOfMatchingNumbers;
    }

}
