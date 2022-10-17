package lotto.domain;

import step3.util.LottoNumberGenerator;

import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        this.numbers = generator.getLottoNumbers();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
