package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Number> numbers = new ArrayList<>();

    private LottoNumbers() {
        while (numbers.size() < LOTTO_NUMBERS_SIZE) {
            numbers.add(Number.create());
        }
    }

    private LottoNumbers(String[] splitNumbers) {
        for (String number : splitNumbers) {
            numbers.add(Number.of(number));
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
        return numbers;
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
