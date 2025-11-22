package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<NumberElement> numbers;

    public Lotto(Integer... numbers) {
        this(Arrays.stream(numbers).map(NumberElement::create).collect(Collectors.toSet()));
    }

    public Lotto(Set<NumberElement> numbers) {
        validationCount(numbers);
        this.numbers = numbers;
    }

    private static void validationCount(Set<NumberElement> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("동일한 번호는 입력할 수 없으며, 로또 번호는 6개만 입력할 수 있습니다.");
        }
    }

    public void validateOverlapBonusNumber(NumberElement bonusNumber) {
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("지난 주 당첨번호에 포함된 번호입니다.");
        }
    }

    public int matchCount(Lotto winningLotto) {
        return (int) winningLotto.numbers.stream()
                .filter(this.numbers::contains)
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
