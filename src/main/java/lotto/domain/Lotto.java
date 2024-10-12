package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는" + LottoConstant.LOTTO_SIZE + "개여야 합니다.");
        }

        if (numbers.stream().anyMatch(number -> !isNumberValid(number))) {
            throw new IllegalArgumentException("로또 번호는 " + LottoConstant.LOTTO_START_NUMBER + "부터 " + LottoConstant.LOTTO_END_NUMBER + "사이여야 합니다.");
        }
    }

    private boolean isNumberValid(int number) {
        return number >= LottoConstant.LOTTO_START_NUMBER && number <= LottoConstant.LOTTO_END_NUMBER;
    }
}
