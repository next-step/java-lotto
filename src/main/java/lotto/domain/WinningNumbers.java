package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by yusik on 2019/11/05.
 */
public class WinningNumbers {

    private static final int WINNING_NUMBER_SIZE = 6;
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new RuntimeException("당첨 번호는 6개 입니다.");
        }
    }

    public Map<WinningRanking, Long> getWinningTickets(List<LotteryTicket> tickets) {
        return tickets.stream()
                .filter(ticket -> Objects.nonNull(ticket.getRanking(winningNumbers)))
                .collect(groupingBy(ticket -> ticket.getRanking(winningNumbers), counting()));
    }
}
