package step2.domain;

import step2.strategy.NumberMakeStrategy;

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

    public WinningMatchCount compareWinningNumber(final List<Integer> winningNumber) {
        winningNumber.forEach(number -> winningMatchCount.match(markingNumbers, number));
        //TODO enum 타입의 최종 당첨 등수를 반환하는 로직 추가 필요
        return winningMatchCount;
    }


}
