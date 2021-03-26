package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    LOSE(0, 0),
    ONE(6, 2000000000),
    THREE(5, 1500000),
    FOUR(4, 50000),
    FIVE(3, 5000)
    ;

    private final int matchCount;
    private final long winAmount;

    LottoRank(int matchCount, long winAmount) {
        this.matchCount = matchCount;
        this.winAmount = winAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinAmount() {
        return winAmount;
    }

    public static LottoRank getEnum(int matchCount) {
        if(matchCount < FIVE.getMatchCount()) {
            return LOSE;
        }
        Optional<LottoRank> find = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount)
                .findFirst();
        if(find.isPresent()) {
            return find.get();
        }
        throw new IllegalArgumentException();
    }
}
