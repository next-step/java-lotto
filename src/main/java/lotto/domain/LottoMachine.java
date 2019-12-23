package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoMachine {

    static List<Integer> generate() {

        List<Integer> numbers = IntStream
                .rangeClosed(LottoPolicy.LOTTO_MINIMUM_NUMBER, LottoPolicy.LOTTO_MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return Collections.unmodifiableList(numbers.subList(0, LottoPolicy.LOTTO_SIZE));
    }
}
