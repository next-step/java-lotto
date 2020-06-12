package step2.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public final static List<LottoRank> WINNING_RANKS = Collections.unmodifiableList(Arrays.asList(
            FIRST,
            SECOND,
            THIRD,
            FOURTH,
            FIFTH
    ));

    private final int countOfMatch;
    private final int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(countOfMatch, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private boolean isMatch(int countOfMatch, boolean matchBonus) {
        if (this.countOfMatch != countOfMatch) {
            return false;
        }

        if (isBonusRequired()) {
            return matchBonus;
        }

        return true;
    }

    public boolean isBonusRequired() {
        return this == SECOND;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    @Override
    public String toString() {
        return "LottoRank{" +
                "countOfMatch=" + countOfMatch +
                ", winningMoney=" + winningMoney +
                '}';
    }
}
