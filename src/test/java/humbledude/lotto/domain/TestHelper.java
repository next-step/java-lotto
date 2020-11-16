package humbledude.lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestHelper {
    public static Set<LottoNumber> setOf(int ... numbers) {
        return IntStream.of(numbers)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
