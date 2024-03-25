package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMaker {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 50).boxed().collect(Collectors.toList());

    private static final int LOTTO_NUMBER_COUNT = 6;

    private LottoMaker() {
    }

    public static List<Integer> getNumbers(){
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.stream().limit(LOTTO_NUMBER_COUNT).collect(Collectors.toUnmodifiableList());
    }
}
