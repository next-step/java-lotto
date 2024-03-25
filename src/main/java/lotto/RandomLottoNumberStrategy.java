package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {
    @Override
    public List<Integer> numbers() {
        List<Integer> list = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return list.subList(0, 6);
    }
}
