package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberShuffler {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final int[] LOTTO_NUMBERS = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).toArray();

    private NumberShuffler() {
    }

    public static List<Integer> getShuffledNumbers() {
        List<Integer> shuffledNumbers = toIntegerList(LOTTO_NUMBERS);
        Collections.shuffle(shuffledNumbers);
        return extractLottoNumbers(shuffledNumbers);
    }

    private static List<Integer> toIntegerList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    private static List<Integer> extractLottoNumbers(List<Integer> shuffledNumbers) {
        return shuffledNumbers.subList(0, 6);
    }
}
