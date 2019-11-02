package lotto.domain;

import lotto.util.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class LottoTicket {

    private List<Integer> numbers;

    LottoTicket(){
        this(new NumberGenerator().generateNumbers());
    }

    LottoTicket(String text){
        this(new NumberGenerator().generateNumbers(text));
    }

    private LottoTicket(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
