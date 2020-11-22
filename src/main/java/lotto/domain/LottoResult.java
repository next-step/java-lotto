package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int winningCount;
    private final int prize;

    private LottoResult(int winningCount, int prize) {
        this.winningCount = winningCount;
        this.prize = prize;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoResult check(Lotto lotto, LottoWinningNumber lottoWinningNumber, int bonusNumber) {
        int winningCount = lottoWinningNumber.sameNumberOfCount(lotto.getLottoNumbers());
        if(lottoWinningNumber.isMatchUpToBonusNumber(lotto.getLottoNumbers(),bonusNumber)) {
            return LottoResult.valueOf(winningCount,true);
        }
        return LottoResult.valueOf(winningCount,false);
    }

    private static LottoResult valueOf(int winningCount, boolean matchBonus) {
        if(winningCount == SECOND.winningCount && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(LottoResult.values())
                .filter(e -> e != SECOND)
                .filter(e -> e.getWinningCount() == winningCount)
                .findFirst()
                .orElse(NONE);
    }

}
