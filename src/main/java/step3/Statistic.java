package step3;

import step3.VO.Money;

import java.util.HashMap;

public class Statistic {
    // results results[0] : 당첨X, results[0] : 1등 ~~ results[5] : 6등
    private final Integer[] results = {0, 0, 0, 0, 0, 0};
    private final HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>() {
        {
            put(0, 6);
            put(1, 6);
            put(2, 6);
            put(3, 5);
            put(4, 4);
            put(5, 3);
            put(6, 1);
        }
    };

    public float getMargin(Money money) {
        float totalReward = 0;
        for (int i = 1; i < RewardBoard.maxRank; i++) {
            totalReward += RewardBoard.getReward(i).getReward() * results[i - 1];
        }
        return money.getMarginByMoney(totalReward);
    }

    public int getResultByIndex(int index) {
        return results[index];
    }

    public int getResultLength() {
        return results.length;
    }

    public void recordLottoResult(int winningCnt, boolean bonusFlag) {
        results[getRankByWinningCnt(winningCnt, bonusFlag)-1] += 1;
    }

    public int getRankByWinningCnt(int winningCnt, boolean bonusNumberFlag) {
        if (winningCnt == 5 && bonusNumberFlag) {
            return 2;
        }
        return rankMap.get(winningCnt);
    }

    public int getWinningCntByRank(int rank) {
        return rankMap.get(rank);
    }
}
