package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoNumberGenerator {

    private static List<Integer> numbers = IntStream.range(1, 46)
            .boxed()
            .collect(Collectors.toList());

    public static int[] generateLottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6).stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
