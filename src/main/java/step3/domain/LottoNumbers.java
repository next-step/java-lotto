package step3.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {

        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }

        if (isLottoNumberRange(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자만 사용해야 합니다.");
        }

        numbers.sort(Comparator.naturalOrder());
        this.numbers = Collections.unmodifiableList(numbers);

        if (hasDuplicateNumber()) {
            throw new IllegalArgumentException("로또 번호는 중복된 수를 포함하면 안됩니다.");
        }
    }

    private boolean isLottoNumberRange(List<Integer> numbers) {
        return numbers.stream()
                      .anyMatch(number -> number < 1 || number > 45);
    }

    private boolean hasDuplicateNumber() {
        return new HashSet<>(numbers).size() != 6;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
