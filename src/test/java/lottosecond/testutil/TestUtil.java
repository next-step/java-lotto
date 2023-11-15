package lottosecond.testutil;


import lottosecond.domain.lotto.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestUtil {

    public static Set<LottoNumber> makeLottoNumberSet(int ...numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public static List<LottoNumber> makeLottoNumberList(int ...numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
