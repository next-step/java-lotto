package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;
import static lotto.domain.lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.LottoNumber.MIN_LOTTO_NUMBER;

public class AutoGeneratingStrategy implements LottoGeneratingStrategy {
    private static final List<LottoNumber> LOTTO_NUMBER_POOL = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .mapToObj(LottoNumber::valueOf)
            .sorted()
            .collect(Collectors.toList());

    @Override
    public Lotto lotto() {
        Collections.shuffle(LOTTO_NUMBER_POOL);
        return Lotto.valueOf(new ArrayList<>(LOTTO_NUMBER_POOL.subList(0, LOTTO_NUMBER_SIZE)));
    }
}
