package step4.domain.lotto;

import step4.domain.lotto.firstcollection.LottoNumber;
import step4.domain.lotto.firstcollection.MarkingNumbers;
import step4.strategy.NumberMakeStrategy;
import step4.type.LottoType;
import step4.type.WinningType;

import java.util.Set;

public class LottoTicket {
    private final MarkingNumbers markingNumbers;
    private final LottoType lottoType;

    public LottoTicket(NumberMakeStrategy strategy) {
        this(strategy.create(), LottoType.AUTO);
    }

    public LottoTicket(Set<LottoNumber> markingNumber, LottoType lottoType) {
        this.markingNumbers = new MarkingNumbers(markingNumber);
        this.lottoType = lottoType;
    }

    public LottoTicket(String string) {
        this.markingNumbers = MarkingNumbers.of(string);
        this.lottoType = LottoType.MANUAL;
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

    public boolean equalsType(LottoType type) {
        return lottoType.equals(type);
    }
}
