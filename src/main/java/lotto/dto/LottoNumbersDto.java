package lotto.dto;

import java.util.Set;

public class LottoNumbersDto {
    private final Set<Integer> numbers;

    public LottoNumbersDto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

}
