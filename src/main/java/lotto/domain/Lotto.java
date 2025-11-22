package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Lotto {

    private final List<NumberElement> numbers;

    public Lotto(Integer[] numbers) {
        this(Arrays.stream(numbers).map(NumberElement::new).toList());
    }

    public Lotto(List<NumberElement> numbers) {
        validationCount(numbers);
        validationOverlap(numbers);
        this.numbers = numbers;
    }

    private void validationOverlap(List<NumberElement> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("동일한 번호는 입력할 수 없습니다.");
        }
    }

    private static void validationCount(List<NumberElement> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개만 입력할 수 있습니다.");
        }
    }

    public void validateOverlapBonusNumber(NumberElement bonusNumber) {
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("지난 주 당첨번호에 포함된 번호입니다.");
        }
    }

    public int matchCount(Lotto winningLotto) {
        return (int) IntStream.range(0, this.numbers.size())
                .filter(index -> this.numbers.contains(winningLotto.numbers.get(index)))
                .count();
    }

    public boolean checkBonusNumber(NumberElement bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }


}
