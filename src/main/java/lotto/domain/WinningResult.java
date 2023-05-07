package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {

    public static final Map<Rank, Integer> DEFAULT_RANKING_COUNTS = new EnumMap<>(Rank.class) {{
        put(Rank.FIRST_GRADE, 0);
        put(Rank.SECOND_GRADE, 0);
        put(Rank.THIRD_GRADE, 0);
        put(Rank.FOURTH_GRADE, 0);
        put(Rank.FIFTH_GRADE, 0);
    }};

    private final Map<Rank, Integer> winningResult;

    private WinningResult(Map<Rank, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public static WinningResult of(Map<Rank, Integer> map) {
        return new WinningResult(map);
    }

    public static WinningResult of(WinningNumbers winningNumbers, Lottos lottos) {
        WinningResult result = ofDefault();
        result.matchLottos(winningNumbers, lottos);
        return result;
    }

    private static WinningResult ofDefault() {
        return new WinningResult(new EnumMap<>(WinningResult.DEFAULT_RANKING_COUNTS));
    }

    private void matchLottos(WinningNumbers winningNumbers, Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            matchLotto(winningNumbers, lotto);
        }
    }

    private void matchLotto(WinningNumbers winningNumbers, Lotto lotto) {
        int winningCount = winningNumbers.winningCountOf(lotto);
        boolean isBonusMatch = winningNumbers.isBonusMatch(winningCount, lotto);
        updateRank(winningCount, isBonusMatch);
    }

    private void updateRank(int winningCount, boolean isBonusMatch) {
        if (isNotWinningCondition(winningCount, isBonusMatch)) {
            return;
        }
        updateRankCount(rank(winningCount, isBonusMatch));
    }

    private Rank rank(int winningCount, boolean isBonusMatch) {
        return Rank.of(winningCount, isBonusMatch);
    }

    private void updateRankCount(Rank rank) {
        winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
    }

    private boolean isNotWinningCondition(int winningCount, boolean isBonusMatch) {
        return Rank.isNotWinning(winningCount, isBonusMatch);
    }

    public Map<Rank, Integer> result() {
        return new EnumMap<>(winningResult);
    }

}
