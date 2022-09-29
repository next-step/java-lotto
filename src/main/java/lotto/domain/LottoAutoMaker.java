package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoMaker {


    private static final List<LottoNumber> numbers = IntStream.range(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE + 1)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    private LottoAutoMaker() {
    }

    public static Lotto makeLotto() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, Lotto.SIZE));
    }
}
