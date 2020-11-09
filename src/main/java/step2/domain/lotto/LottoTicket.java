package step2.domain.lotto;

import step2.strategy.NumberMakeStrategy;
import step2.type.WinningType;

import java.util.List;

public class LottoTicket {
    private final MarkingNumbers markingNumbers;
    private final WinningMatchCount winningMatchCount;

    public LottoTicket(NumberMakeStrategy strategy) {
        this(strategy.create());
    }

    public LottoTicket(List<Integer> markingNumber) {
        this.markingNumbers = new MarkingNumbers(markingNumber);
        winningMatchCount = new WinningMatchCount();
    }

    public String getMarkingNumbers() {
        return markingNumbers.toString();
    }

    public boolean isMarked(int number) {
        return markingNumbers.contains(number);
    }

    public WinningType compareWinningNumber(final WinningNumber winningNumber) {
        winningMatchCount.clear();
        winningNumber.getList()
                .forEach(number -> winningMatchCount.match(markingNumbers, number));
        return winningMatchCount.getWinningType();
    }

    @Override
    public String toString() {
        return markingNumbers.toString();
    }
}
