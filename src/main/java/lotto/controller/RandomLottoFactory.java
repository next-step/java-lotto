package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;
import static java.util.stream.Collectors.toList;

public class RandomLottoFactory implements LottoFactory {

    @Override
    public Lotto lotto() {
        List<LottoNumber> candidates = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
                .mapToObj(LottoNumber::new)
                .collect(toList());
        shuffle(candidates);

        List<LottoNumber> numbers = IntStream.range(0, Lotto.SIZE)
                .mapToObj(candidates::get)
                .collect(toList());

        return new Lotto(numbers);
    }
}
