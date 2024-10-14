package lotto.dto;

import java.util.List;

public class LottoNumbersDto {
    private final List<Integer> numbers;

    public LottoNumbersDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
