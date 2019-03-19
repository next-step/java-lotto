package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {
    private List<Integer> baseNumbers() {
        return IntStream.range(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public Lotto generateLotto() {
        List<Integer> baseNumbers = baseNumbers();
        Collections.shuffle(baseNumbers);
        return new Lotto(baseNumbers.subList(BASE_INDEX, Lotto.SIZE_LIMIT));
    }
}
