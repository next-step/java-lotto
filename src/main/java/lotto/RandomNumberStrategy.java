package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomNumberStrategy implements LottoNumberStrategy {
    //FIXME: rangeClosed 를 이용해서 1 ~ 45 명시적 표현 :)
    private final static int[] NUMBERS = IntStream.range(1, 46).toArray();
    private final static int LOTTO_SIZE = 6;

    @Override
    public List<Number> provideNumberSet() {
        List<Number> collect = Number.of(NUMBERS);
        Collections.shuffle(collect);
        return collect.subList(0, LOTTO_SIZE);
    }
}
