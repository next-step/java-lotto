package lotto.util;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LottoStringFixtureUtil {
    public static Set<LottoNumber> convertStringToLottoNumberList(String fixtureLottoNumber) {
        return Arrays.stream(fixtureLottoNumber.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
