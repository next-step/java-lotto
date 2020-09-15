package step2.controller;

public enum Revenue {
    REWARD_4ST(5000),
    REWARD_3ST(50000),
    REWARD_2ST(1500000),
    REWARD_1ST(2_000_000_000);

    private static final int LOTTO_PRICE = 1000;
    private final int money;

    Revenue(int money) {
        this.money = money;
    }

    public static float create(int count, int[] result) {
        int sum = 0;
        Revenue[] revenues = values();
        for(int i = 0; i < result.length; i++) {
            sum += result[i] * revenues[i].money;
        }
        return (float)sum / (count * LOTTO_PRICE);
    }
}