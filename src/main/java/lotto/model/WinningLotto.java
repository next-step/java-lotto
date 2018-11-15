package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final int LOTTO_NUMBER_DIGIT = 6;
    private static final int LOTTO_NUMBER_START_RANGE = 1;
    private static final int LOTTO_NUMBER_END_RANGE = 45;

    private List<Integer> numbers;
    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        validation(numbers);
        this.numbers = new ArrayList(numbers);

        validation(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }


    public boolean isBonusMatch(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    public int matchCount(List<Integer> numbers) {
        numbers.retainAll(this.numbers);
        return numbers.size();
    }

    private void validation(Integer bonusNumber) {
        validationNumberRange(bonusNumber);
        validationNumberDuplicate(bonusNumber);
    }

    private void validation(List<Integer> numbers) {
        validationNumberDuplicate(numbers);
        validationNumberDigit(numbers);
        validationNumberRange(numbers);
    }

    private void validationNumberDuplicate(List<Integer> numbers) {
        if(!numbers.stream().allMatch(new ArrayList<>()::add)) {
            throw new IllegalArgumentException("숫자는 중복하여 입력할 수 없습니다.");
        }
    }

    private void validationNumberDuplicate(Integer bonusNumber) {
        if(this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("숫자는 중복하여 입력할 수 없습니다.");
        }
    }

    private void validationNumberDigit(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_DIGIT) {
            throw new IllegalArgumentException("숫자는 6개 까지 입력하세요.");
        }
    }

    private void validationNumberRange(List<Integer> numbers) {
        numbers.forEach(number ->  {
            validationNumberRange(number);
        });
    }

    private void validationNumberRange(Integer number) {
        if(number < LOTTO_NUMBER_START_RANGE || number >LOTTO_NUMBER_END_RANGE) {
            throw new IllegalArgumentException("숫자는 1부터 45사이의 값을 입력하세요.");
        }
    }
}
