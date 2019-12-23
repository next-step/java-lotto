package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoMachine {

    static List<LottoNumber> generate() {

        List<LottoNumber> numbers = IntStream
                .rangeClosed(LottoPolicy.LOTTO_MINIMUM_NUMBER, LottoPolicy.LOTTO_MAXIMUM_NUMBER)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return Collections.unmodifiableList(numbers.subList(0, LottoPolicy.LOTTO_SIZE));
    }
}
