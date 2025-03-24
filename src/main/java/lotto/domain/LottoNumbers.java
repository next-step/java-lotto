package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final List<Integer> LOTTO_NUMBERS = initNumbers();

    private LottoNumbers() {
    }

    private static List<Integer> initNumbers() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> shuffleLottoNumbers() {
        List<Integer> shuffled = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(shuffled);
        return shuffled.subList(0, 6);
    }
}
