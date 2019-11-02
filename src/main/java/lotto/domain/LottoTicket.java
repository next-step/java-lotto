package lotto.domain;

import lotto.util.NumberGenerator;

import java.util.List;

public class LottoTicket {

    private List<Integer> numbers;


    LottoTicket() {
        this(new NumberGenerator().generateNumbers());
    }

    LottoTicket(String text) {
        this(new NumberGenerator().generateNumbers(text));
    }

    private LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }


    public int countCompareWinNumbers(LottoTicket winNumbers) {
        return (int) numbers.stream().filter(number -> winNumbers.contains(number)).count();
    }

    public boolean contains(int num) {
        return (numbers.contains(num));
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
