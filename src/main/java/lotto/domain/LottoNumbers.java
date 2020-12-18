package lotto.domain;

import lotto.exception.LottoNumberCountNotEnoughException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        Optional.ofNullable(numbers)
                .map(list -> list.stream().collect(Collectors.toSet()))
                .orElseThrow(LottoNumberCountNotEnoughException::new);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
