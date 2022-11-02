package Lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Random {
    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    public static List<Integer> generateRandomLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new ArrayList<>(LOTTO_NUMBERS.subList(0, 6));
    }
}
