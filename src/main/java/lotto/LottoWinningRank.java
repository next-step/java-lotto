package lotto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public enum LottoWinningRank {
    NONE(0, null),
    MATCHES_THREE(5_000, WinningCondition.builder().matchedCount(3).build()),
    MATCHES_FOUR(50_000, WinningCondition.builder().matchedCount(4).build()),
    MATCHES_FIVE(1_500_000, WinningCondition.builder().matchedCount(5).build()),
    MATCHES_SIX(2_000_000_000, WinningCondition.builder().matchedCount(6).build());

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
        WinningCondition winningCondition = getWinningConditionOf(winningNumbers, boughtLottoNumbers);
        LottoWinningRank lottoWinningRank = WINNING_CONDITION_LOTTO_WINNING_RANK_MAP.get(winningCondition);
        return lottoWinningRank != null ? lottoWinningRank : NONE;
    }

    private static WinningCondition getWinningConditionOf(Collection<Integer> winningNumbers, Collection<Integer> boughtLottoNumbers) {
        int matchedCount = (int) boughtLottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        return WinningCondition.builder()
                .matchedCount(matchedCount)
                .build();
    }
}
