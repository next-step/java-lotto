package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int MIN_MATCH_COUNT = 0;
    private static final int MAX_MATCH_COUNT = 6;

    private final int matchCount;
    private final int winningMoney;

    public int matchCount() {
        return this.matchCount;
    }

    public int winningMoney() {
        return this.winningMoney;
    }

    public int countWinningMoney(int matchLottoCount) {
        return this.winningMoney * matchLottoCount;
    }

    LottoRank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static LottoRank findLottoRank(int matchCount, boolean matchBonus) {
        validateMatchCount(matchCount);
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.isSameMatchCount(matchCount))
                .filter(lottoRank -> lottoRank != SECOND || matchBonus)
                .findAny()
                .orElse(MISS);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private static void validateMatchCount(int matchCount) {
        if (matchCount > MAX_MATCH_COUNT || matchCount < MIN_MATCH_COUNT) {
            throw new IllegalArgumentException(String.format("일치하는 로또 갯수가 0에서 6을 벗어날 수 없습니다. (현재 찾고자 하는 로또 갯수 : %d)", matchCount));
        }
    }
}
