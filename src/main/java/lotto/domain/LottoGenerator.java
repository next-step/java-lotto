package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final List<Integer> SAMPLE = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
            .boxed()
            .collect(Collectors.toList());

    private LottoGenerator() {
    }

    public static Lotto getLotto() {
        return new Lotto(getLottoNumbers());
    }

    private static List<Integer> getLottoNumbers() {
        List<Integer> shuffle = shuffledList().subList(0, Lotto.SIZE);
        shuffle.sort(Integer::compareTo);
        return shuffle;
    }

    private static List<Integer> shuffledList() {
        List<Integer> shuffle = new ArrayList<>(SAMPLE);
        Collections.shuffle(shuffle);
        return shuffle;
    }
}
