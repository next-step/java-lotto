package step3.domain.lotto;

import step3.strategy.NumberMakeStrategy;

import java.util.Set;

public class LottoTicket {
    private final MarkingNumbers markingNumbers;

    public LottoTicket(NumberMakeStrategy strategy) {
        this(strategy.create());
    }

    public LottoTicket(Set<LottoNumber> markingNumber) {
        this.markingNumbers = new MarkingNumbers(markingNumber);
    }

    public String getMarkingNumbers() {
        return markingNumbers.toString();
    }

    public boolean isMarked(LottoNumber number) {
        return markingNumbers.contains(number);
    }

    @Override
    public String toString() {
        return markingNumbers.toString();
    }

}
