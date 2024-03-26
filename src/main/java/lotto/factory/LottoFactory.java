package lotto.factory;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static Lotto issueLotto() {
        List<Integer> numbers = setLottoRange();
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, 6));
    }

    private static List<Integer> setLottoRange() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }
}
