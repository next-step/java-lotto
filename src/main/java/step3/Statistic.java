package step3;

import step3.VO.Money;

import java.util.HashMap;
import java.util.Map;

public class Statistic {
    // results results[0] : 당첨X, results[0] : 1등 ~~ results[5] : 6등
    private final Integer[] results = {0, 0, 0, 0, 0, 0};
    private final Map<Integer, RewardBoard> rankMap = new HashMap<Integer, RewardBoard>() {
        {
            put(0, RewardBoard.MISS);
            put(1, RewardBoard.MISS);
            put(2, RewardBoard.MISS);
            put(3, RewardBoard.FIFTH);
            put(4, RewardBoard.FOURTH);
            put(5, RewardBoard.THIRD);
            put(6, RewardBoard.FIRST);
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
        results[getRankByWinningCnt(winningCnt, bonusFlag) - 1] += 1;
    }

    public int getRankByWinningCnt(int winningCnt, boolean bonusNumberFlag) {
        if (winningCnt == 5 && bonusNumberFlag) {
            return 2;
        }
        return rankMap.get(winningCnt).getRank();
    }

    public int getWinningCntByRank(int rank) {
        return rankMap.get(rank).getRank();
    }
}
