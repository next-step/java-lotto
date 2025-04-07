package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoNumberGenerator {

    private static List<Integer> numbers = IntStream.range(1, 46)
            .boxed()
            .collect(Collectors.toList());

    public static LottoNumbers generateLottoNumbers() {
        Collections.shuffle(numbers);
        return new LottoNumbers(
                numbers.subList(0, 6).stream()
                        .mapToInt(Integer::intValue)
                        .toArray()
        );
    }

    public static LottoNumbers parseIntsFromString(String numberString) {
        return new LottoNumbers(
                Arrays.stream(numberString.split(","))
                        .map(Integer::parseInt)
                        .mapToInt(Integer::intValue)
                        .toArray()
        );
    }
}
