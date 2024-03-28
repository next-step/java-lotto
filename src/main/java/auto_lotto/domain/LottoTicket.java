package auto_lotto.domain;

import java.util.List;

public class LottoTicket {

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    //주생성자
    public LottoTicket(RandomNumber randNumbers) {
        this.numbers = randNumbers.randNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    List<Integer> numbers;
}
