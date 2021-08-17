package lotto;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fixtures {
    public static List<LottoNumber> makeLottoNumbers(Integer... integers) {
        return Arrays.stream(integers)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
