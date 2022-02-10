package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class Util {

    public static Lotto stringToLottoNumberList(String unrefinedNumber) {
        return new Lotto(Arrays.asList(unrefinedNumber.split(", ")).stream()
            .map(n -> new LottoNumber(Integer.parseInt(n)))
            .collect(Collectors.toSet()));
    }
}
