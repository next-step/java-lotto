package lotto.model;


import java.util.Arrays;

public enum Rank {
    three(3, 5000),
    four(4, 50000),
    five(5, 1500000),
    six(6, 2000000000),
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

    public static Rank of(int num){
        return Arrays.stream(Rank.values())
                .filter(op -> op.isEqual(num))
                .findAny()
                .orElse(NONE);
    }

    public Money getReward() {
        return reward;
    }

    public boolean isWin(){
        return this != NONE;
    }
}
