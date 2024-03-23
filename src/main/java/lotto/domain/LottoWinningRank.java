package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoWinningRank {

    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);


    private final int matchCount;
    private final boolean requireMatchBonus;
    private final int winningPrice;


    LottoWinningRank(int matchCount, boolean requireMatchBonus, int winningPrice) {
        this.matchCount = matchCount;
        this.requireMatchBonus = requireMatchBonus;
        this.winningPrice = winningPrice;
    }

    public static Optional<LottoWinningRank> findByMatchCount(int matchCount, boolean matchBonus) {
        return Arrays.stream(LottoWinningRank.values())
                .filter(lottoResult -> matchCount == lottoResult.matchCount && lottoResult.requireMatchBonus == matchBonus)
                .findAny()
                .or(() -> Arrays.stream(LottoWinningRank.values())
                        .filter(lottoResult -> matchCount == lottoResult.matchCount)
                        .findAny());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getRequireMatchBonus() {
        return requireMatchBonus;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
