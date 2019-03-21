package lotto.domain;

import lotto.util.LottoBasicNumber;

import java.util.List;

public class LuckyLotto {
    private static final int NUMBER_COUNT = 6;

    private List<Integer> numbers;
    private int bonusNumber;

    public LuckyLotto(List<Integer> numbers, int bonusNumber) {
        if (isWrong(numbers, bonusNumber)) {
            throw new RuntimeException();
        }
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    //TODO : 입력숫자개수, 숫자범위 확인하도록 추가
    private boolean isWrong(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != NUMBER_COUNT) {
            return true;
        }

        if (!LottoBasicNumber.checkNumberRange(bonusNumber)) {
            return true;
        }

        if (!LottoBasicNumber.checkNumberRange(numbers)) {
            return true;
        }

        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
