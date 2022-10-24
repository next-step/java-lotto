package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LENGTH = 6;

    private final List<LottoNumber> numbers;

    Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    Lotto() {
        this.numbers = randomNumbers();
    }

    public int correctCount(Lotto myLotto) {
        return (int) numbers.stream().filter(myLotto.numbers::contains).count();
    }

    public List<LottoNumber> getSortedNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }

    private List<LottoNumber> randomNumbers() {
        List<LottoNumber> numbers = shuffle(MIN_NUMBER, MAX_NUMBER + 1);
        return numbers.subList(0, LENGTH);
    }

    private List<LottoNumber> shuffle(int min, int max) {
        List<LottoNumber> range = IntStream.range(min, max).boxed().map(v -> new LottoNumber(v)).collect(Collectors.toList());
        Collections.shuffle(range);

        return range;
    }
}
