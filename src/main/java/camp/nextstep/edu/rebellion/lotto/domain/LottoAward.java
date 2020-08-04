package camp.nextstep.edu.rebellion.lotto.domain;

import java.util.Arrays;

public enum LottoAward {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSE(0, 0);

    private int matchCount;
    private int prize;

    LottoAward(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoAward of(int matchCount) {
        return Arrays.stream(values())
                .filter(award -> award.match(matchCount))
                .findFirst()
                .orElse(LOSE);
    }

    private boolean match(int matchCount) {
        return (this.matchCount == matchCount);
    }
}
