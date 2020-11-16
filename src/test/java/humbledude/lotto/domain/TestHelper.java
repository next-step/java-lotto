package humbledude.lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestHelper {
    public static Set<Integer> setOf(int ... numbers) {
        return IntStream.of(numbers)
                .boxed()
                .collect(Collectors.toSet());
    }
}
