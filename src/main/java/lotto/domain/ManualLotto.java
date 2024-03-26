package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLotto {

    private final List<ManualLottoNumber> numbers;

    public ManualLotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
                .map(ManualLottoNumber::new)
                .collect(Collectors.toList());
    }

    public void validateNumbers(List<Integer> numbers){
        validateSize(numbers);
        validateIfDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIfDuplication(List<Integer> numbers) {
        int count = (int) numbers.stream()
                .distinct()
                .count();
        if(numbers.size() != count){
            throw new IllegalArgumentException();
        }
    }
}
