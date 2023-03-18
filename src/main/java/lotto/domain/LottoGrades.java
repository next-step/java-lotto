package lotto.domain;

import java.util.Arrays;

public class LottoGrades {

    public enum LottoGrade {
        FIRST(6, 2000000000),
        SECOND(5, 30000000),
        THIRD(5, 1500000),
        FOURTH(4, 50000),
        FIFTH(3, 5000),
        NONE(2, 0);

        private final int matchCount;
        private final int prizeMoney;

        LottoGrade(int matchCount, int prizeMoney) {
            this.matchCount = matchCount;
            this.prizeMoney = prizeMoney;
        }

        public int getMatchCount() {
            return this.matchCount;
        }

        public int getPrizeMoney() {
            return this.prizeMoney;
        }
    }

    public static final LottoGrade getLottoGrade(long matchCount, boolean hasBonusBall) {

        LottoGrade matchGrade = Arrays.stream(LottoGrade.values())
                .filter(grade -> grade != LottoGrade.NONE)
                .filter(lottoGrade -> lottoGrade.matchCount == matchCount)
                .findFirst()
                .orElse(LottoGrade.NONE);

        if(matchGrade == LottoGrade.SECOND && hasBonusBall == false) {
            return LottoGrade.THIRD;
        }

        return matchGrade;
    }
}
