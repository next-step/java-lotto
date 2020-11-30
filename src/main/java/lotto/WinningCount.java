package lotto;

import java.util.List;
import java.util.Objects;

public class WinningCount {

    private int count;

    public WinningCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(Message.VALIDATION_WINNING_COUNT);
        }
        this.count = count;
    }

    public WinningCount increaseCountManager(LottoTicket lottoTicket, List<Integer> lastWeeksWinningNumbers) {
        for (Integer lastWeeksWinningNumber : lastWeeksWinningNumbers) {
            increaseCount(lottoTicket.getTicket(), lastWeeksWinningNumber);
        }

        return new WinningCount(count);
    }

    private void increaseCount(List<Integer> ticket, Integer lastWeeksWinningNumber) {
        if (ticket.contains(lastWeeksWinningNumber)) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningCount that = (WinningCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
