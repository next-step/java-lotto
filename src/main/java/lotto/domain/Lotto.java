package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numberExceptionCheck(numbers);
        duplicateNumberCheck(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public Integer getLottoSize() {
        return this.numbers.size();
    }

    private void duplicateNumberCheck(List<Integer> numbers) {
        if (numbers.stream().distinct().count() < 6)
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
    }

    private void numberExceptionCheck(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty())
            throw new IllegalArgumentException("로또 번호가 없습니다.");
    }
}
