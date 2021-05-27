package domain;

import java.util.Arrays;

public class LottoNumberMatch {
    private LottoNumberMatch () { }

    public static Integer matchCount(Integer[] winNumber, Lotto lotto) {
        Integer matchCount = 0;
        for (Integer number : winNumber) {
            matchCount = Arrays.asList(lotto.numbers()).contains(number) ? matchCount+1 : matchCount;
        }
        lotto.matchCount(matchCount);
        return matchCount;
    }
}
