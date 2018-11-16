package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_DIGIT = 6;
    private static final int LOTTO_NUMBER_START_RANGE = 1;
    private static final int LOTTO_NUMBER_END_RANGE = 45;

    List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validation(numbers);
        this.numbers = new ArrayList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchCount(Lotto lotto) {
        lotto.numbers.retainAll(this.numbers);
        return lotto.numbers.size();
    }

    protected void validation(List<Integer> numbers) {
        validationNumberDuplicate(numbers);
        validationNumberDigit(numbers);
        validationNumberRange(numbers);
    }

    protected void validationNumberDuplicate(List<Integer> numbers) {
        if(!numbers.stream().allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException("숫자는 중복하여 입력할 수 없습니다.");
        }
    }

    protected void validationNumberDigit(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_DIGIT) {
            throw new IllegalArgumentException("숫자는 6개 까지 입력하세요.");
        }
    }

    protected void validationNumberRange(List<Integer> numbers) {
        numbers.forEach(number ->  {
            validationNumberRange(number);
        });
    }

    protected void validationNumberRange(Integer number) {
        if(number < LOTTO_NUMBER_START_RANGE || number >LOTTO_NUMBER_END_RANGE) {
            throw new IllegalArgumentException("숫자는 1부터 45사이의 값을 입력하세요.");
        }
    }
}
