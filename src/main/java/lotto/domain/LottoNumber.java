package lotto.domain;

import java.util.*;

public class LottoNumber {

    private static final String DELIMITER = ",";
    private final Set<Integer> numbers;

    public LottoNumber(String input) {
        validate(input);
        numbers = addNumbers(new TreeSet<>(), input);
    }

    public LottoNumber(int size, RandomNumberGenerator randomNumberGenerator) {
        numbers = addRandomNumbers(new TreeSet<>(), size, randomNumberGenerator);
    }

    public int matchCount(LottoNumber otherLottoNumber) {
        int matchCount = 0;
        for (int number : otherLottoNumber.numbers) {
            matchCount = plusOneIfMatch(matchCount, number);
        }
        return matchCount;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 입력입니다.");
        }
    }

    private Set<Integer> addNumbers(Set<Integer> numbers, String input) {
        for (String s : input.split(DELIMITER)) {
            numbers.add(Integer.parseInt(s.strip()));
        }
        return numbers;
    }

    private Set<Integer> addRandomNumbers(Set<Integer> numbers, int size, RandomNumberGenerator generator) {
        while (numbers.size() != size) {
            numbers.add(generator.generate());
        }
        return numbers;
    }

    private int plusOneIfMatch(int matchCount, int number) {
        if (numbers.contains(number)) {
            matchCount++;
        }
        return matchCount;
    }
}
