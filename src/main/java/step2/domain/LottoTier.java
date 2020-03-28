package step2.domain;

import java.util.Arrays;

public enum LottoTier {

    FIRST(6, 2000000000),
    SECOND(5, 150000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private int matchedNumberCount;
    private int prize;

    LottoTier(int matchedNumberCount, int prize) {
        this.matchedNumberCount = matchedNumberCount;
        this.prize = prize;
    }

    public static LottoTier getResult(int matchedNumberCount) {
        if(matchedNumberCount == 6) {
            return FIRST;
        }
        else if(matchedNumberCount == 5) {
            return SECOND;
        }
        else if(matchedNumberCount == 4) {
            return THIRD;
        }
        else if(matchedNumberCount == 3) {
            return FOURTH;
        }
        else {
            return NONE;
        }
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public int getPrize() {
        return prize;
    }
}
