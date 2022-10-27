package lotto.strategy;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface LottoGenerateStrategy {

    int LOTTO_MAX_NUM = 45;
    int LOTTO_MIN_NUM = 1;
    List<Integer> NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
            .boxed()
            .collect(Collectors.toList());

    Set<Integer> generateLotto();

}
