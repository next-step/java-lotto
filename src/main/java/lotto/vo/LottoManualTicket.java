package lotto.vo;

import java.util.List;

import lotto.domain.LottoNo;

import static java.util.stream.Collectors.toList;

public class LottoManualTicket {
    private final List<LottoNo> numbers;

    public LottoManualTicket(List<LottoNo> numbers) {
        this.numbers = numbers;
    }

    public static LottoManualTicket from(List<Integer> numbers) {
        return new LottoManualTicket(numbers.stream()
            .map(LottoNo::new)
            .collect(toList()));
    }

    public List<LottoNo> getNumbers() {
        return numbers;
    }
}
