package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<LottoNumber> numbers = new ArrayList<>();
    private final int NUMBERS_MAX_SIZE = 6;

    public Lotto(List<Integer> inputLottoNumbers) {
        for (Integer inputNumber : inputLottoNumbers) {
            checkCanAdd(inputNumber);
            numbers.add(LottoNumber.valueOf(inputNumber));
        }
        Collections.sort(numbers);
    }

    private void checkCanAdd(Integer inputNumber) {
        checkNumberSize();
        checkDuplicateNumber(inputNumber);
    }

    private void checkNumberSize() {
        if (NUMBERS_MAX_SIZE <= numbers.size()) {
            throw new IllegalArgumentException("Lotto`s size status is max, So can not add number.");
        }
    }

    private void checkDuplicateNumber(int inputNumber) {
        for (LottoNumber number : numbers) {
            number.checkDuplicateNumber(LottoNumber.valueOf(inputNumber));
        }
    }

    public final List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int countWinningNumber(List<LottoNumber> winningNumbers) {
        return (int) numbers.stream()
                .filter(element -> winningNumbers.contains(element))
                .count();
    }

    public boolean hasBonus(LottoNumber bonus) {
        return numbers.stream()
                .anyMatch(e -> e.getResultIfEqual(bonus) == 1);
    }

    public void checkWinningHasBonus(LottoNumber bonus) {
        if (hasBonus(bonus)) {
            throw new IllegalArgumentException("Don`t put bonus in winning lotto");
        }
    }
}
