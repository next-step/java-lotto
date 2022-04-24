package me.devyonghee.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RandomGenerator implements LottoTicketGenerator {

    private static final RandomGenerator GENERATOR = new RandomGenerator();
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .mapToObj(LottoNumber::from)
            .collect(Collectors.toList());
    private static final int START_NUMBER_INDEX = 0;

    private RandomGenerator() {
        if (GENERATOR != null) {
            throw new AssertionError();
        }
    }

    public static RandomGenerator getInstance() {
        return GENERATOR;
    }

    @Override
    public Lotto lotto() {
        List<LottoNumber> numbers = new ArrayList<>(ALL_LOTTO_NUMBERS);
        Collections.shuffle(numbers);
        return Lotto.from(LottoNumbers.from(numbers.subList(START_NUMBER_INDEX, Lotto.NUMBER_SIZE)));
    }
}
