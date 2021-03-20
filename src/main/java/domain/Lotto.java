package domain;

import exception.NegativeException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
//        Collections.shuffle(Collections.singletonList(numbers));
//        Collections.sort(Collections.singletonList(numbers));
    }

    private void validate(Set<Integer> numbers) {
        validateLengthNumber(numbers);
        validateNegativeNumber(numbers);
        validateExceedNumber(numbers);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public void validateLengthNumber(Set<Integer> numbers) {
        if(numbers.size() != 6){
            throw new RuntimeException("6개의 번호를 입력해주세요");
        }
    }
    private void validateExceedNumber(Set<Integer> numbers) {
        if(Collections.max(numbers) > MAX_NUMBER) {
            throw new RuntimeException("45 숫자를 초과 할 수 없습니다.");
        }
    }

    private static void validateNegativeNumber(Set<Integer> numbers) {
        if(Collections.min(numbers) < MIN_NUMBER) {
            throw new NegativeException("음수는 입력 할 수 없습니다.");
        }
    }

}
