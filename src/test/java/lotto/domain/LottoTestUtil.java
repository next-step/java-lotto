package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTestUtil {

    public static Lotto toLottoNumberList(int... args) {
        return new Lotto(IntStream.of(args)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));

    }
}
