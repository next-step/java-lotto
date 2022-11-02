package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LENGTH = 6;

    private final List<LottoNumber> numbers;

    Lotto(List<LottoNumber> numbers) {
        validate(numbers);
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

    private List<LottoNumber> randomNumbers() {
        List<LottoNumber> numbers = LottoNumber.shuffleNumbers();
        return numbers.subList(0, LENGTH);
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.stream().mapToInt(lottoNumber -> lottoNumber.getNumber()).distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("유니크한 값으로만 구성해야합니다.");
        }
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
}
