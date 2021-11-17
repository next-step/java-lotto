package step2.domain;

import step2.utils.RandomUtils;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Number> numbers = new ArrayList<>();

    private LottoNumbers() {
        while (numbers.size() < LOTTO_NUMBERS_SIZE) {
            add();
        }
    }

    private LottoNumbers(String[] splitNumbers) {
        for (String number : splitNumbers) {
            numbers.add(Number.of(number));
        }
    }

    private void add() {
        Number number = Number.create(RandomUtils.nextInt());
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public static LottoNumbers create() {
        return new LottoNumbers();
    }

    public static LottoNumbers of(String[] splitNumbers) {
        return new LottoNumbers(splitNumbers);
    }

    public int match(List<Number> targetNumbers) {
        List<Number> tempNumbers = numbers;
        tempNumbers.retainAll(targetNumbers);
        return tempNumbers.size();
    }

    public List<Number> getNumbers() {
        return numbers.stream()
                .sorted(Comparator.comparing(Number::getNumber))
                .collect(Collectors.toList());
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
