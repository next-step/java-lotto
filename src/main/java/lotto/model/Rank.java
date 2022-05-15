package lotto.model;


import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int coincidence;
    private final Money reward;

    Rank(int coincidence, Money reward) {
        this.coincidence = coincidence;
        this.reward = reward;
    }

    Rank(int coincidence, int reward) {
        this.coincidence = coincidence;
        this.reward = new Money(reward);
    }

    public boolean isEqual(int coincidence){
        return this.coincidence == coincidence;
    }

    public static Rank of(int num, boolean bonesBall){
        if(num == 5 && bonesBall){
            return Rank.SECOND;
        }
        if(num == 5){
            return Rank.THIRD;
        }

        return  Arrays.stream(Rank.values())
                .filter(op -> op.isEqual(num))
                .findAny()
                .orElse(NONE);
    }

    public Money getReward() {
        return reward;
    }

    public int getCoincidence() {
        return coincidence;
    }

    public boolean isWin(){
        return this != NONE;
    }
}
