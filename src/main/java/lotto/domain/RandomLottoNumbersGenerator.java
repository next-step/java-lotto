package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumbersGenerator implements LottoNumbersGenerator {

    @Override
    public Set<LottoNumber> generate() {
        List<Integer> collect = IntStream
                .rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(collect);

        return collect.stream()
                .limit(Lotto.LOTTO_NUMBER_SIZE)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
