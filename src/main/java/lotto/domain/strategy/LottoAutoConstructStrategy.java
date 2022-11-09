package lotto.domain.strategy;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoAutoConstructStrategy implements LottoConstructStrategy {

    @Override
    public List<Set<Integer>> create(int count) {
        return IntStream.rangeClosed(1, count)
            .mapToObj(value -> getLottoNumbers())
            .collect(toList());
    }

    private static Set<Integer> getLottoNumbers() {
        Collections.shuffle(Lotto.NUMBER_LIST);
        return Lotto.NUMBER_LIST.stream()
            .limit(Lotto.LOTTO_COUNT)
            .collect(Collectors.toSet());
    }
}
