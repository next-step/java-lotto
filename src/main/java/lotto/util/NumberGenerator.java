package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {
    private static final List<Integer> BASE_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(
        Collectors.toList());
    private static final int NUMBERS_COUNT = 6;

    public static List<Integer> generateLottoNumbers() {
        List<Integer> shuffledNumbers = new ArrayList<>(BASE_NUMBERS);
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers.subList(0, NUMBERS_COUNT).stream().sorted().collect(Collectors.toList());
    }
}
