package lotto;

import java.util.Arrays;
import java.util.List;

public class WiningStatistic {
    // Count 클래스를 만들어야겠다?
    private static int count;

    public static List<Integer> winningCounts(LottoTickets lottoTickets, List<Integer> lastWeeksWinningNumbers) {
        List<Integer> winningsCounts = Arrays.asList(0, 0, 0, 0);

        for (int i = 0; i < lottoTickets.size(); i++) {
            increaseWinningCounts(lottoTickets, lastWeeksWinningNumbers, i);
            setWinningCounts(winningsCounts);

            count = 0;
        }


        return winningsCounts;
    }

    private static void increaseWinningCounts(LottoTickets lottoTickets, List<Integer> lastWeeksWinningNumbers, int i) {
        List<Integer> ticket = lottoTickets.getLottoTicket(i).getTicket();
        for (Integer lastWeeksWinningNumber : lastWeeksWinningNumbers) {
            increaseWinningCounts(ticket, lastWeeksWinningNumber);
        }
    }

    private static void increaseWinningCounts(List<Integer> ticket, Integer lastWeeksWinningNumber) {
        if (ticket.contains(lastWeeksWinningNumber)) {
            ++count;
        }
    }

    private static void setWinningCounts(List<Integer> winningsCounts) {
        // Enum으로 뺄 수 있겠다?
        if (count == 3) {
            winningsCounts.set(0, winningsCounts.get(0) + 1);
        } else if (count == 4) {
            winningsCounts.set(1, winningsCounts.get(1) + 1);
        } else if (count == 5) {
            winningsCounts.set(2, winningsCounts.get(2) + 1);
        } else if (count == 6) {
            winningsCounts.set(3, winningsCounts.get(3) + 1);
        }
    }
}
