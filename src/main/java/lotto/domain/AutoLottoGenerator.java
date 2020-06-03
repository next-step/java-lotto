package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT_OF_LOTTO_NUMBER = 6;
    private static final List<Integer> LOTTO_NUMBER_LIST = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());

    @Override
    public Lotto generate() {
        Collections.shuffle(LOTTO_NUMBER_LIST);
        List<Integer> numberList = LOTTO_NUMBER_LIST.subList(0, COUNT_OF_LOTTO_NUMBER);
        return new Lotto(numberList);
    }
}
