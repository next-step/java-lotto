package step2;

import java.util.Arrays;

public enum LottoReward {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 150000),
    SIX_MATCH(6, 2000000000);

    private int matchNumber;
    private int rewardPrice;
    private int count;

    LottoReward(int matchNumber, int rewardPrice) {
        this.matchNumber = matchNumber;
        this.rewardPrice = rewardPrice;
    }

    public void increaseCount() {
        count++;
    }

    public int getTotalRewardPrice() {
        return rewardPrice * count;
    }

    public static double calcYield(int price) {
        int totalRewardPrice = Arrays.stream(values())
                .mapToInt(LottoReward::getTotalRewardPrice)
                .sum();
        return (double) totalRewardPrice / price;
    }

    public static void calcMatchCount(Lotto lotto, Lotto lastWeekWinningLotto) {
        Arrays.stream(values())
                .filter(lottoReward -> lottoReward.matchNumber == lotto.getMatchCount(lastWeekWinningLotto))
                .findFirst()
                .ifPresent(LottoReward::increaseCount);
    }

    public static void printResult() {
        Arrays.stream(values())
                .forEach(lottoReward -> System.out.println(String.format("%d개 일치 (%d원)- %d개",
                        lottoReward.matchNumber, lottoReward.rewardPrice, lottoReward.count)));

    }

}
