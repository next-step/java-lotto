package lotto.dto;

public class MatchingLotteryDto {
    String rankCount;
    String amount;
    int countMatching;

    public MatchingLotteryDto(String rankCount, String profit, int countMatching) {
        this.countMatching = countMatching;
        this.amount = profit;
        this.rankCount = rankCount;
    }

    public String getRankCount() {
        return rankCount;
    }

    public String getAmount() {
        return amount;
    }

    public int getCountMatching() {
        return countMatching;
    }
}
