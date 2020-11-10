package step2.domain.lotto;

import step2.strategy.NumberMakeStrategy;
import step2.type.WinningType;

import java.util.List;
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

    public boolean isMarked(int number) {
        return markingNumbers.contains(number);
    }


    @Override
    public String toString() {
        return markingNumbers.toString();
    }

    public boolean contains(int number) {
        return markingNumbers.contains(number);
    }
}
