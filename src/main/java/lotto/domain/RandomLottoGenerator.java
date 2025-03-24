package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator {
    public Lotto generate() {
        List<Integer> numbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(numbers);

        List<LottoNumber> selectedNumbersList = numbers.subList(0, Lotto.SIZE).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        return new Lotto(selectedNumbersList);
    }

}
