package lotto.domain;

import java.util.List;

public class LottoTicket {

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket(RandomNumbers randNumbers) {
        this.numbers = randNumbers.lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    List<Integer> numbers;
}
