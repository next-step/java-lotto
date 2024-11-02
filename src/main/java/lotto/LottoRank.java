package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000, MatchBonus.TRUE),
    THIRD(5, 1500000, MatchBonus.FALSE),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private int lottoMatchingCount;
    private int lottoWinningAmount;
    private MatchBonus matchBonus;


    LottoRank(int lottoMatchingCount, int lottoWinningAmount, MatchBonus matchBonus) {
        this.lottoMatchingCount = lottoMatchingCount;
        this.lottoWinningAmount = lottoWinningAmount;
        this.matchBonus = matchBonus;
    }

    LottoRank(int lottoMatchingCount, int lottoWinningAmount) {
        this.lottoMatchingCount = lottoMatchingCount;
        this.lottoWinningAmount = lottoWinningAmount;
        this.matchBonus = matchBonus.NONE;
    }

    //머니볼이 true이면서 5개면 랭크 2 아니면 랭크 3
    public static LottoRank rank(int matchingCount, boolean isMatchingBonus) {
        return Arrays.stream(values())
                .filter(i -> i.lottoMatchingCount == matchingCount)
                .filter(i -> i.matchBonus.match(isMatchingBonus)).findFirst()
                .orElse(NONE);
    }

    public int lottoWinningAmount() {
        return this.lottoWinningAmount;
    }

    public int lottoMatchingCount() {
        return this.lottoMatchingCount;
    }

    private enum MatchBonus {
    NONE {
        @Override
        public boolean match(boolean isBonusMatch) {
            return true;
        }
    }, TRUE {
        @Override
        public boolean match(boolean isBonusMatch) {
            return isBonusMatch;
        }
    }, FALSE {
        @Override
        public boolean match(boolean isBonusMatch) {
            return !isBonusMatch;
        }
    };
    public abstract boolean match(boolean isBonusMatch);
}


}
