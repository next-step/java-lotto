package lotto.domain;

import java.util.List;

public class ManualLotto {

    private final List<Integer> numbers;

    public ManualLotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public void validateNumbers(List<Integer> numbers){
        int count = (int) numbers.stream()
                .distinct()
                .count();
        if(numbers.size() != count){
            throw new IllegalArgumentException();
        }
    }
}
