package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static List<Integer> NUMBER_LIST = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    private LottoNumbers() {}

    public static List<Integer> shuffle() {
        Collections.shuffle(NUMBER_LIST);
        return NUMBER_LIST;
    }
}
