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
    private static final int WINNING_NUMBER_MIN = 1;
    private static final int WINNING_NUMBER_MAX = 45;

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateRange(winningNumbers);
        validateDuplicate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public Map<WinningRanking, Long> getWinningTickets(List<LotteryTicket> tickets) {
        return tickets.stream()
                .filter(ticket -> Objects.nonNull(ticket.getRanking(winningNumbers)))
                .collect(groupingBy(ticket -> ticket.getRanking(winningNumbers), counting()));
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_SIZE) {
            String message = String.format("당첨 번호는 %d개 입니다.", WINNING_NUMBER_SIZE);
            throw new RuntimeException(message);
        }
    }

    private void validateRange(List<Integer> winningNumbers) {
        boolean outOfRange = winningNumbers.stream()
                .anyMatch(number -> number < WINNING_NUMBER_MIN || number > WINNING_NUMBER_MAX);
        if (outOfRange) {
            String message = String.format("당첨 번호의 범위는 [%d, %d] 입니다.", WINNING_NUMBER_MIN, WINNING_NUMBER_MAX);
            throw new RuntimeException(message);
        }
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        boolean duplicate = winningNumbers.stream()
                .distinct()
                .count() != winningNumbers.size();
        if (duplicate) {
            throw new RuntimeException("당첨 번호는 중복될 수 없습니다.");
        }
    }
}
