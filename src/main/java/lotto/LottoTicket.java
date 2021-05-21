package lotto;

import java.util.List;

public class LottoTicket {

    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int countOfNumbers() {
        return numbers.size();
    }
}
