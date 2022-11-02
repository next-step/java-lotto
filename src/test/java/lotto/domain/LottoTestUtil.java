package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTestUtil {

    public static List<LottoNumber> toLottoNumberList(int... args) {
        return IntStream.of(args)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

    }
}
