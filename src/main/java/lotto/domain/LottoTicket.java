package lotto.domain;

import java.util.List;

public class LottoTicket {

    private List<Integer> numbers;

    LottoTicket(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
