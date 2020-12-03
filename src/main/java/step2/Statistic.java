package step2;

public class Statistic {
    public static Integer[] results = {0, 0, 0, 0, 0, 0, 0};

    public static float getMargin(int money) {
        float totalReward = 0;
        for (int i = 3; i <= 6; i++) {
            totalReward += RewardBoard.getReward(i).getReward() * results[i];
        }
        return totalReward/money;
    }

    public static void recordLottoResult(int winningCnt) {
        results[winningCnt] += 1;
    }
}
