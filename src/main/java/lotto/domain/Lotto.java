package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는" + LottoConstant.LOTTO_SIZE + "개여야 합니다.");
        }

        if (numbers.stream().distinct().count() != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }

        if (numbers.stream().anyMatch(number -> !isNumberValid(number))) {
            throw new IllegalArgumentException("로또 번호는 " + LottoConstant.LOTTO_START_NUMBER + "부터 " + LottoConstant.LOTTO_END_NUMBER + "사이여야 합니다.");
        }

    }

    private boolean isNumberValid(int number) {
        return number >= LottoConstant.LOTTO_START_NUMBER && number <= LottoConstant.LOTTO_END_NUMBER;
    }
}
