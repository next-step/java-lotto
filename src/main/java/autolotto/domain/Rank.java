package autolotto.domain;

import java.util.Arrays;

public enum Rank {
    NO_MATCH(0,0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private int matchCount;
    private int money;
    private boolean matchBonus;

    Rank(int matchCount, int money, boolean matchBonus) {
        this.matchCount = matchCount;
        this.money = money;
        this.matchBonus = matchBonus;
    }

    public static Rank of(int matchCount, boolean matchBonus){
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .findFirst()
                .orElse(NO_MATCH);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getMoney() {
        return money;
    }

    public String  getDescription() {
        if(matchBonus){
            return matchCount + "개 일치, 보너스 볼 일치 (" + money + "원)";
        }
        return matchCount + "개 일치 (" + money + "원)";
    }
}
