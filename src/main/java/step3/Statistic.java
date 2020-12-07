package step3;

import step3.VO.Money;

public class Statistic {
    // results results[0] : 당첨X, results[0] : 1등 ~~ results[5] : 6등
    public static Integer[] results = {0, 0, 0, 0, 0, 0};
    // 2등 통계 index
    public static int secondRankIndex = 4;

    public static float getMargin(Money money) {
        float totalReward = 0;
        for (int i = 1; i < RewardBoard.maxRank; i++) {
            totalReward += RewardBoard.getReward(i).getReward() * results[i - 1];
        }
        return money.getMarginByMoney(totalReward);
    }

    public static void recordLottoResult(int winningCnt, boolean bonusFlag) {
        results[RewardBoard.getRankByWinningCnt(winningCnt, bonusFlag)-1] += 1;
    }
}
