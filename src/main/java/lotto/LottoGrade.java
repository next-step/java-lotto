package lotto;

import java.util.Arrays;

public class LottoGrade {

    public enum LOTTO_GRADE {
        FIRST(6, 2000000000),
        SECOND(5, 30000000),
        THIRD(5, 1500000),
        FOURTH(4, 50000),
        FIFTH(3, 5000),
        NONE(2, 0);

        private final int matchCount;
        private final int prizeMoney;

        LOTTO_GRADE(int matchCount, int prizeMoney) {
            this.matchCount = matchCount;
            this.prizeMoney = prizeMoney;
        }
    }

    public static final LOTTO_GRADE getLottoGrade(long matchCount, boolean hasBonusBall) {

        LOTTO_GRADE matchGrade = Arrays.stream(LOTTO_GRADE.values())
                .filter(grade -> grade != LOTTO_GRADE.NONE)
                .filter(lottoGrade -> lottoGrade.matchCount == matchCount)
                .findFirst()
                .orElse(LOTTO_GRADE.NONE);

        if(matchGrade == LOTTO_GRADE.SECOND && hasBonusBall == false) {
            return LOTTO_GRADE.THIRD;
        }

        return matchGrade;
    }
}
