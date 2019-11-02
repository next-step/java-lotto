package lotto.domain;

import lotto.util.NumberGenerator;

import java.util.List;

public class LottoTicket {

    private List<Integer> numbers;

    LottoTicket(){
        this(new NumberGenerator().generateSixNumbers());
    }

    LottoTicket(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
