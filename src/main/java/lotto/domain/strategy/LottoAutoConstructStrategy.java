package lotto.domain.strategy;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoAutoConstructStrategy implements LottoConstructStrategy {
    private static final List<Integer> numList = IntStream
        .rangeClosed(1, 45)
        .boxed()
        .collect(toList());

    @Override
    public List<Lotto> create(int count) {
        return IntStream.rangeClosed(1, count)
            .mapToObj(value -> getLottoNumbers())
            .map(Lotto::from)
            .collect(toList());
    }

    private static Set<Integer> getLottoNumbers() {
        Collections.shuffle(numList);
        return numList.stream()
            .limit(LOTTO_COUNT)
            .collect(Collectors.toSet());
    }
}
