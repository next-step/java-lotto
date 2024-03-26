package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {

    private final static List<Integer> RANGE_NUMS = IntStream.rangeClosed(1, 45)
            .boxed().collect(Collectors.toList());
    @Override
    public List<Integer> numbers() {
        Collections.shuffle(RANGE_NUMS);
        return RANGE_NUMS.subList(0, 6);
    }
}
