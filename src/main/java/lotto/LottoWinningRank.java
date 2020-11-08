package lotto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public enum LottoWinningRank {
    NONE(0, null),
    MATCHES_THREE(5_000, new WinningCondition(3)),
    MATCHES_FOUR(50_000, new WinningCondition(4)),
    MATCHES_FIVE(1_500_000, new WinningCondition(5)),
    MATCHES_SIX(2_000_000_000, new WinningCondition(6));

    private static class WinningCondition {
        private final int matchedCount;

        public WinningCondition(int matchedCount) {
            this.matchedCount = matchedCount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof WinningCondition)) return false;

            WinningCondition that = (WinningCondition) o;

            return matchedCount == that.matchedCount;
        }

        @Override
        public int hashCode() {
            return matchedCount;
        }
    }

    private static final Map<WinningCondition, LottoWinningRank> WINNING_CONDITION_LOTTO_WINNING_RANK_MAP;
    static {
        WINNING_CONDITION_LOTTO_WINNING_RANK_MAP = new HashMap<>();
        for (LottoWinningRank rank : LottoWinningRank.values()) {
            WINNING_CONDITION_LOTTO_WINNING_RANK_MAP.put(rank.winningCondition, rank);
        }
    }

    private final int winningAmount;
    private final WinningCondition winningCondition;

    LottoWinningRank(int winningAmount, WinningCondition winningCondition) {
        this.winningAmount = winningAmount;
        this.winningCondition = winningCondition;
    }

    public static LottoWinningRank getWinningRank(Collection<Integer> winningNumbers, Collection<Integer> boughtLottoNumbers) {
        int matchCount = 0;
        for (Integer boughtLottoNumber : boughtLottoNumbers) {
            if (winningNumbers.contains(boughtLottoNumber)) {
                matchCount++;
            }
        }

        WinningCondition winningCondition = new WinningCondition(matchCount);
        LottoWinningRank lottoWinningRank = WINNING_CONDITION_LOTTO_WINNING_RANK_MAP.get(winningCondition);
        return lottoWinningRank != null ? lottoWinningRank : NONE;
    }
}
