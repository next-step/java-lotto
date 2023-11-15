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

    public static int[] getShuffledNumbers() {
        List<Integer> shuffledNumbers = toIntegerList(LOTTO_NUMBERS);
        Collections.shuffle(shuffledNumbers);
        return toIntArray(shuffledNumbers.subList(0, 6));
    }

    private static List<Integer> toIntegerList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    private static int[] toIntArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
