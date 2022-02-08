package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;

public class Util {

    public static List<LottoNumber> stringToLottoNumberList(String unrefinedNumber) {
        return Arrays.asList(unrefinedNumber.split(", ")).stream().map(n -> new LottoNumber(Integer.parseInt(n))).collect(
            Collectors.toList());
    }
}
