package lotto.vo;

import java.util.List;

public class LottoManualTicket {
    private final List<Integer> numbers;

    public LottoManualTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int lottoManualCount() {
        return numbers.size();
    }
}
