package lotto.domain;
import java.util.Arrays;

public enum Reward {
    FIRST(6,2000000000),
    SECOND_BONUS(5,3000000),
    SECOND(5,1500000),
    THIRD(4,50000),
    FOURTH(3,5000),
    ZERO(0,0);

    private int numberMatch;
    private int rewordMoney;

    Reward(int numberMatch, int rewordMoney) {
        this.numberMatch = numberMatch;
        this.rewordMoney = rewordMoney;
    }

    public static Reward rewardMatchCount(int count, boolean bonusWinning) {
        if(bonusWinning){
            return SECOND_BONUS;
        }
        return Arrays.stream(values())
                .filter(reward -> reward.numberMatch == count)
                .findFirst()
                .orElse(Reward.ZERO);
    }

    public int getNumberMatch() {
        return numberMatch;
    }

    public int getRewordMoney() {
        return rewordMoney;
    }
}
