package lotto.domain;

import java.util.List;

public class LottoTicket {

    private List<LottoNumber> numbers;

    LottoTicket() {
        this(new NumberGenerator().generateNumbers());
    }

    LottoTicket(String text) {
        this(new NumberGenerator().generateNumbers(text));
    }

    private LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int getMatchCount(LottoTicket inputTicket) {
        return (int) numbers.stream()
                .filter(number -> inputTicket.contains(number))
                .count();
    }

    public boolean contains(LottoNumber num) {
        return (numbers.contains(num));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
