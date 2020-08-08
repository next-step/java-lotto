package camp.nextstep.edu.rebellion.lotto.domain;

import java.util.Arrays;

public enum LottoAward {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private int countOfMatch;
    private int prize;

    LottoAward(int countOfMatch, int prize) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoAward valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(award -> award.countOfMatch == countOfMatch)
                .filter(award-> !award.equals(SECOND) || matchBonus)
                .findFirst()
                .orElse(LOSE);
    }
}
