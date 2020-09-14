package step2.controller;

public class MakeRevenue {
    private static final int REWARD_1ST = 2000000000;
    private static final int REWARD_2ST = 1500000;
    private static final int REWARD_3ST = 50000;
    private static final int REWARD_4ST = 5000;
    private static final int LOTTO_PRICE = 1000;

    public static float create(int count, int[] result) {
        int sum = 0;
        sum += result[0] * REWARD_4ST;
        sum += result[1] * REWARD_3ST;
        sum += result[2] * REWARD_2ST;
        sum += result[3] * REWARD_1ST;
        return (float)sum / (count * LOTTO_PRICE);
    }
}
