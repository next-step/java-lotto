package step2.model;

import java.util.List;

public abstract class LottoTicket {

    private List<LottoNumber> numbers;

    protected LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
