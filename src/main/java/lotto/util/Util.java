package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;

public class Util {

    public static List<LottoNumber> stringToIntegerList(String unrefinedNumber) {
        return Arrays.asList(unrefinedNumber.split(", ")).stream()
            .map(Integer::parseInt)
            .map(LottoNumber::from)
            .collect(Collectors.toList());
    }
}
