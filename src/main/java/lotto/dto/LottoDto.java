package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public class LottoDto {
    private final List<Integer> numbers;

    public LottoDto(Lotto numbers) {
        this(numbers.generateReport().getNumbers());
    }

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
