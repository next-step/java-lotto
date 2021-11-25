package step2.domain;

import step2.strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_NUMBER_LENGTH = 6;

    private final List<Number> numbers = new ArrayList<>();

    private LottoNumbers(NumberGeneratorStrategy generatorStrategy) {
        while (numbers.size() < LOTTO_NUMBERS_SIZE) {
            add(generatorStrategy);
        }
    }

    private LottoNumbers(String[] splitNumbers) {
        validateNumbersLength(splitNumbers);
        for (String number : splitNumbers) {
            numbers.add(Number.of(number));
        }
    }

    public static LottoNumbers create(NumberGeneratorStrategy generatorStrategy) {
        return new LottoNumbers(generatorStrategy);
    }

    public static LottoNumbers of(String[] splitNumbers) {
        return new LottoNumbers(splitNumbers);
    }

    private void add(NumberGeneratorStrategy generatorStrategy) {
        Number number = Number.create(generatorStrategy.generate());
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public int match(List<Number> targetNumbers) {
        List<Number> tempNumbers = new ArrayList<>(numbers);
        tempNumbers.retainAll(targetNumbers);
        return tempNumbers.size();
    }

    public List<Number> getNumbers() {
        return numbers.stream()
                .sorted(Comparator.comparing(Number::getNumber))
                .collect(Collectors.toList());
    }

    private void validateNumbersLength(String[] splitNumbers) {
        if (splitNumbers.length != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(getNumbers(), that.getNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumbers());
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "numbers=" + numbers +
                '}';
    }
}
