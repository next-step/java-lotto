package lotto.domain;

import lotto.util.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class LottoTicket {

    private List<Integer> numbers;

    LottoTicket(){
        this(new NumberGenerator().generateSixNumbers());
    }

    LottoTicket(String text){
        this(new NumberGenerator().generateSixNumbers(text));
    }

    LottoTicket(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
