package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final LottoNumbers numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public LottoTicket(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    public int winningCount(LottoTicket lottoTicket) {
        return numbers.countMatchingNumbers(lottoTicket.getNumbers());
    }

}
