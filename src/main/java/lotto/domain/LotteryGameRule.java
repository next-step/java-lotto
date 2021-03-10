package lotto.domain;

public class LotteryGameRule {

    private final int firstPrizeReward;

    private final int secondPrizeReward;

    private final int thirdPrizeReward;

    private final int fourthPrizeReward;

    private final int firstPrizeMatchingCount;

    private final int secondPrizeMatchingCount;

    private final int thirdPrizeMatchingCount;

    private final int fourthPrizeMatchingCount;

    private final int lotteryTicketPrice;

    public LotteryGameRule() {
        firstPrizeReward = 2000000000;
        secondPrizeReward = 1500000;
        thirdPrizeReward = 50000;
        fourthPrizeReward = 5000;
        firstPrizeMatchingCount = 6;
        secondPrizeMatchingCount = 5;
        thirdPrizeMatchingCount = 4;
        fourthPrizeMatchingCount = 3;
        lotteryTicketPrice = 1000;
    }


    public int getFirstPrizeReward() {
        return firstPrizeReward;
    }

    public int getSecondPrizeReward() {
        return secondPrizeReward;
    }

    public int getThirdPrizeReward() {
        return thirdPrizeReward;
    }

    public int getFourthPrizeReward() {
        return fourthPrizeReward;
    }

    public int getFirstPrizeMatchingCount() {
        return firstPrizeMatchingCount;
    }

    public int getSecondPrizeMatchingCount() {
        return secondPrizeMatchingCount;
    }

    public int getThirdPrizeMatchingCount() {
        return thirdPrizeMatchingCount;
    }

    public int getFourthPrizeMatchingCount() {
        return fourthPrizeMatchingCount;
    }

    public int getLotteryTicketPrice() {
        return lotteryTicketPrice;
    }
}
