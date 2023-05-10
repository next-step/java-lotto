package lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerate {
    private static final int ZERO = 0;
    private static final int LOTTO_MAX_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static List<Integer> initLottoNumbers() {
        List<Integer> numbers =  IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        return sortNumber(shuffleNumber(numbers).subList(ZERO, LOTTO_MAX_SIZE));
    }

    private static List<Integer> shuffleNumber(List<Integer> numberList) {
        Collections.shuffle(numberList);

        return numberList;
    }

    private static List<Integer> sortNumber(List<Integer> numberList) {
        Collections.sort(numberList);

        return numberList;
    }
}
