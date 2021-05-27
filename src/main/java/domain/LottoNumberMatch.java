package domain;

import java.util.Arrays;

public class LottoNumberMatch {
    private LottoNumberMatch () { }

    public static Integer matchCount(Integer[] winNumber, Integer[] lottoNumber) {
        Integer matchCount = 0;
        for (Integer number : winNumber) {
            matchCount = Arrays.asList(lottoNumber).contains(number) ? matchCount+1 : matchCount;
        }
        return matchCount;
    }
}
