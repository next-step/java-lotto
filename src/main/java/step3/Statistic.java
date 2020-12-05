package step3;

public class Statistic {
    // results results[0] : 당첨X, results[1] : 5등 ~~ results[5] : 1등
    public static Integer[] results = {0, 0, 0, 0, 0, 0};
    // 2등 통계 index
    public static int secondRankIndex = 4;

    public static float getMargin(int money) {
        float totalReward = 0;
        for (int i = 1; i < RewardBoard.maxRank; i++) {
            totalReward += RewardBoard.getReward(i).getReward() * results[i];
        }
        return totalReward/money;
    }

    public static void recordLottoResult(int winningCnt) {
        results[RewardBoard.getRankByWinningCnt(winningCnt, false)] += 1;
    }
}
