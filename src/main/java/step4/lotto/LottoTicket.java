package step4.lotto;

import step4.lotto.firstcollection.LottoNumber;
import step4.lotto.firstcollection.MarkingNumbers;
import step4.strategy.NumberMakeStrategy;
import step4.type.WinningType;

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

    public WinningType compareWinningNumber(WinningNumbers winningNumbers) {
        int matchCount = winningNumbers.countEquals(this);
        return WinningType.getType(matchCount, winningNumbers.isMarkedBonusBall(this));
    }
}
