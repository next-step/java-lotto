package step3.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestUtil {

    static Lotto lottoFixture(Integer... numbers) {
        return new Lotto(
                Arrays.stream(numbers)
                        .map(LottoNumber::of)
                        .collect(Collectors.toList())
        );
    }

}
