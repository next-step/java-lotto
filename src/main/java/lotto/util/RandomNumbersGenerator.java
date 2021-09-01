package lotto.util;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.domain.LottoNumber.SAVED_MAX_NUMBER;
import static lotto.domain.LottoNumber.SAVED_MIN_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;

public class RandomNumbersGenerator {

    private static final int GENERATE_MIN_NUMBER = 0;

    private static final List<LottoNumber> LOTTO_CANDIDATE_NUMBERS = IntStream
        .rangeClosed(SAVED_MIN_NUMBER, SAVED_MAX_NUMBER)
        .boxed()
        .map(LottoNumber::of)
        .collect(Collectors.toList());

    private RandomNumbersGenerator() {
    }

    public static List<LottoNumber> generateNumbers() {
        Collections.shuffle(LOTTO_CANDIDATE_NUMBERS);
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = GENERATE_MIN_NUMBER; i < LOTTO_NUMBERS_SIZE; i++) {
            numbers.add(LOTTO_CANDIDATE_NUMBERS.get(i));
        }
        return numbers;
    }

}
