package lotto.strategy;

import lotto.LottoApplication;
import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoStrategy implements LottoMakeStrategy {

    public List<LottoNumber> valueOf(){
        return numbers().stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static List<Integer> numbers() {
        List<Integer> numbers = IntStream.range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
