package lotto.util;

import lotto.model.dto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.model.dto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.model.dto.LottoNumber.MIN_LOTTO_NUMBER;

public class LottoNumbersCreator implements NumbersCreator {
    @Override
    public List<LottoNumber> create() {
        List<Integer> integers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(integers);
        return integers.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
