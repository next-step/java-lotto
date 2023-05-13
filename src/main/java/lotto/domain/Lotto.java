package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int NUMBER_COUNT = 6;
    private static final List<LottoNumber> AVAILABLE_NUMBERS = LottoNumber.getAvailableLottoNumbers();

    protected List<LottoNumber> numbers;

    public Lotto() {
        List<LottoNumber> randomNumbers = getRandomNumbers();
        numbers = sorted(randomNumbers);
    }

    private List<LottoNumber> getRandomNumbers() {
        List<LottoNumber> shuffleNumbers = new ArrayList<>(AVAILABLE_NUMBERS);
        Collections.shuffle(shuffleNumbers);
        return shuffleNumbers.stream()
                .limit(NUMBER_COUNT)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> sorted(List<LottoNumber> randomNumbers) {
        return randomNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Lotto(List<LottoNumber> inNumbers) {
        validateNumbers(inNumbers);
        numbers = sorted(inNumbers);
    }

    private void validateNumbers(List<LottoNumber> inNumbers) {
        if (inNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("Expected %d numbers, but received %d.", NUMBER_COUNT, inNumbers.size()));
        }
    }

    @Override
    public boolean equals(Object o) {
        return numbers.equals(o);
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(num -> num.toString())
                .collect(Collectors.joining(", ","[","]"));
    }
}
