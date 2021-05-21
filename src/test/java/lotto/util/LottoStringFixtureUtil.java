package lotto.util;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoStringFixtureUtil {
    public static Set<LottoNumber> convertStringToLottoNumberList(String fixtureLottoNumber) {
        return Arrays.stream(fixtureLottoNumber.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public static String[] lottoNumbersSortedByRank() {
        String lottoNumbers[] = new String[9];

        lottoNumbers[1] = "1,2,3,4,5,6";
        lottoNumbers[2] = "1,2,3,4,5,7";
        lottoNumbers[3] = "1,2,3,4,5,16";
        lottoNumbers[4] = "1,2,3,4,15,16";
        lottoNumbers[5] = "1,2,3,14,15,16";
        lottoNumbers[6] = "1,2,13,14,15,16";
        lottoNumbers[7] = "1,12,13,14,15,16";
        lottoNumbers[8] = "11,12,13,14,15,16";

        return lottoNumbers;
    }
}
