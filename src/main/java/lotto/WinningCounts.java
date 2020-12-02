package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinningCounts {

    private final List<WinningCount> winningCountList;

    public WinningCounts() {
        this.winningCountList = new ArrayList<>();
    }

    public WinningCounts(List<WinningCount> winningCountList) {
        this.winningCountList = winningCountList;
    }

    public WinningCounts calculateWinningCount(LottoTickets lottoTickets, List<Integer> lastWeeksWinningNumbers) {
        validateLastWeeksWinningNumbersSize(lastWeeksWinningNumbers);

        for (int i = 0; i < lottoTickets.size(); i++) {
            WinningCount winningCount = new WinningCount(0)
                    .increaseCountManager(lottoTickets.getLottoTicket(i), lastWeeksWinningNumbers);
            winningCountList.add(winningCount);
        }

        return new WinningCounts(winningCountList);
    }

    private static void validateLastWeeksWinningNumbersSize(List<Integer> lastWeeksWinningNumbers) {
        if (lastWeeksWinningNumbers.size() != 6) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 6자리 입니다.");
        }
    }

    public WinningCount getWinningCount(int index) {
        return winningCountList.get(index);
    }

    public int size() {
        return winningCountList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningCounts that = (WinningCounts) o;
        return Objects.equals(winningCountList, that.winningCountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningCountList);
    }
}
