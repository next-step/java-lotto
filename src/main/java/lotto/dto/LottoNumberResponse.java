package lotto.dto;

import java.util.List;

public class LottoNumberResponse {
    private List<String> numbers;

    public LottoNumberResponse(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
