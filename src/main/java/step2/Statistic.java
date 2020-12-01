package step2;

public class Statistic {
    public static Integer[] results = {0, 0, 0, 0, 0, 0};

    public static float getMargin(int money) {
        float totalReward = 0;
        for (int i = 3; i <= 6; i++) {
            totalReward += RewardBoard.getReward(i).getReward() * results[i-1];
        }
        return totalReward/money;
    }

    public static void recordResult(Lottos lottos) {
        results = new Integer[]{0, 0, 0, 0, 0, 0};
        for (Lotto lotto : lottos.getLottoList()) {
            results[lotto.getWinningCnt()] += 1;
        }
    }
}
