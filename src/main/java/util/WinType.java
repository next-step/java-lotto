package util;

public enum WinType {
    LOSE(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int count;
    private int reward;

    WinType(int count, int reward) {
        this.count = count;
        this.reward = reward;
    }

    public static WinType findByCount(int count) {
        for (WinType type : values()) {
            if (type.count == count) {
                return type;
            }
        }
        return LOSE;
    }

    public int getReward() {
        return reward;
    }
}
