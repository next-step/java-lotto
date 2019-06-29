package lotto.util;

import lotto.model.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberGenerator {

    public static List<LottoNumber> generate(Stream<Integer> stream) {
        return stream.map(LottoNumber::new).collect(Collectors.toList());
    }
}
