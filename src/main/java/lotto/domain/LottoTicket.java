package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Number> numbers;

    public LottoTicket(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return this.numbers;
    }

}
