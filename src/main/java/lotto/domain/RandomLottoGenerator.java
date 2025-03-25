package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator {
    private final List<Integer> allNumbers;

    public RandomLottoGenerator() {
        this.allNumbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    public Lotto generate() {
        Collections.shuffle(allNumbers);

        List<LottoNumber> selectedNumbersList = allNumbers.subList(0, Lotto.SIZE).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        return new Lotto(selectedNumbersList);
    }

}
