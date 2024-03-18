package lotto.dto;

import java.util.List;

public class LottoNumberDto {
    private List<String> numbers;

    public LottoNumberDto(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
