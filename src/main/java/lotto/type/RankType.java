package lotto.type;

public enum RankType {
    NO_RANK(0, 0),
    RANK1(2_000_000_000, 6),
    RANK2(1_500_000, 5),
    RANK3(50_000, 4),
    RANK4(5_000, 3);

    private int reward;
    private int condition;

    RankType(int reward, int condition) {
        this.reward = reward;
        this.condition = condition;
    }

    public int totalReward(int count) {
        return this.reward * count;
    }

    public static RankType getRank(int condition) {
        if (condition < RANK4.condition) {
            return NO_RANK;
        }

        if (condition == RANK4.condition) {
            return RANK4;
        }

        if (condition == RANK3.condition) {
            return RANK3;
        }

        if (condition == RANK2.condition) {
            return RANK2;
        }

        return RANK1;
    }
}
