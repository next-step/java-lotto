package lotto.domain;

import java.util.Arrays;

public enum LottoWinningAndPrizeMoney {
      FIRST (6,false,   2_000_000_000)
    , SECOND(5,true,    30_000_000)
    , THIRD (5,false,   1_500_000)
    , FOURTH(4,false,   50_000)
    , FIFTH (3,false,   5_000)
    , LOSE  (0,false,   0)
    ;
    private final int countOfMatch;
    private final boolean bonusNoMatch;
    private final long prizeMoney;

    LottoWinningAndPrizeMoney(int countOfMatch, boolean bonusNoMatch, long prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.bonusNoMatch = bonusNoMatch;
        this.prizeMoney = prizeMoney;
    }

    public static LottoWinningAndPrizeMoney confirmWin(int countOfMatch, boolean bonusNoMatch){
        return Arrays.stream(values())
                     .filter(e -> e.isWinningMatch(countOfMatch, bonusNoMatch))
                     .findAny()
                     .orElse(LOSE)
        ;
    }

    public boolean isWinningMatch(int countOfMatch, boolean bonusNoMatch){
        return this.countOfMatch == countOfMatch
            && this.bonusNoMatch == bonusNoMatch;
    }

    public static boolean isNotLose(LottoWinningAndPrizeMoney lottoWinningAndPrizeMoney){
        return LOSE != lottoWinningAndPrizeMoney;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }
}
