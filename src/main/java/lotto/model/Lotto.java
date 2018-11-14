package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class Lotto {
    private static final int LOTTO_NUMBER_DIGIT = 6;
    private static final int LOTTO_NUMBER_START_RANGE = 1;
    private static final int LOTTO_NUMBER_END_RANGE = 45;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validation(numbers);
        this.numbers = new ArrayList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validation(List<Integer> numbers) {
        validationNumberDuplicate(numbers);
        validationNumberDigit(numbers);
        validationNumberRange(numbers);

    }

    private void validationNumberDuplicate(List<Integer> numbers) {
        if(!numbers.stream().allMatch(new HashSet<>()::add)) {
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
            if(number < LOTTO_NUMBER_START_RANGE || number >LOTTO_NUMBER_END_RANGE) {
                throw new IllegalArgumentException("숫자는 1부터 45사이의 값을 입력하세요.");
            }
        });
    }

    public int matchCount(List<Integer> winnerLotto) {
        this.numbers.retainAll(winnerLotto);
        return numbers.size();
    }

    public int matchCount(Lotto winnerLotto) {

        this.numbers.retainAll(winnerLotto.numbers);
        return numbers.size();
    }
}
