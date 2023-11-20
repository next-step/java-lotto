package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private final List<Integer> numbers;

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private final List<Integer> generateNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());

    public LottoNumber() {
        this.numbers = generateLottoNumbers();
    }

    private List<Integer> generateLottoNumbers() {
        Collections.shuffle(generateNumbers);
        return generateNumbers.subList(0, LOTTO_COUNT);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
