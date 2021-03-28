package step2.domain;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    public static final int NUMBER_SIZE = 6;
    public static final int LOTTO_START_SIZE = 1;
    public static final int LOTTO_END_SIZE = 46;

    private final Set<Integer> lottoNumbers;

    public LottoNumber(Set<Integer> lottoNumbers) {
        boolean allowedNumberRange = lottoNumbers.stream()
                .anyMatch(number -> number < LOTTO_START_SIZE || number >= LOTTO_END_SIZE);

        numbersValidation(lottoNumbers, allowedNumberRange);
        this.lottoNumbers = lottoNumbers;
    }

    private void numbersValidation(Set<Integer> lottoNumbers, boolean allowedNumberRange) {
        if (lottoNumbers == null ||
                lottoNumbers.size() != NUMBER_SIZE || allowedNumberRange)
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
    }

    private Set<Integer> getNumbers(Set<Integer> numbers) {
        if (numbers.isEmpty()) {
            numbers = getShuffledNumbers();
        }
        return numbers;
    }

    private Set<Integer> getShuffledNumbers() {
        List<Integer> generateNumbers = generateNumbers();
        Collections.shuffle(generateNumbers);

        return generateNumbers.stream()
                .limit(NUMBER_SIZE)
                .collect(Collectors.toSet());
    }

    private List<Integer> generateNumbers() {
        return IntStream.range(LOTTO_START_SIZE, LOTTO_END_SIZE)
                .boxed()
                .collect(Collectors.toList());
    }

    public boolean isContains(int number) {
        return this.lottoNumbers.contains(number);
    }

    public int getMatchCount (LottoNumber lottoNumbers) {
        return this.lottoNumbers.stream()
                .map(number -> lottoNumbers.isContains(number))
                .filter(Predicate.isEqual(true))
                .mapToInt(isEqualsNumber -> 1)
                .sum();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
