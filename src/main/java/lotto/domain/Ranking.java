package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Ranking {

    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    FAIL(0, 0);

    private static final int SECOND_COUNTS = 5;

    private final int winnerPrice;
    private final int normalNumberMatchCount;

    Ranking(final int winnerPrice, final int normalNumberMatchCount) {
        this.winnerPrice = winnerPrice;
        this.normalNumberMatchCount = normalNumberMatchCount;
    }

    public static Ranking judgeRanking(LottoResult lottoResult) {
        if (lottoResult.getNormalNumberMatchCount() == SECOND_COUNTS && !lottoResult.getBonusNumberMatch()) {
            return THIRD;
        }

        return Arrays.stream(Ranking.values())
            .filter(rank -> rank.equals(lottoResult))
            .findFirst()
            .orElse(FAIL);
    }

    private boolean equals(LottoResult lottoResult) {
        return this.normalNumberMatchCount == lottoResult.getNormalNumberMatchCount();
    }

    public int multiplyCountAndWinnerPrice(final int count) {
        return winnerPrice * count;
    }

    public boolean isFail() {
        return this == FAIL;
    }

    public int getNormalNumberMatchCount() {
        return normalNumberMatchCount;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }
}
