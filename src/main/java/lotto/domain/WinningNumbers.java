package lotto.domain;

import lotto.util.NumbersValidator;

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
        if (!NumbersValidator.validateSize(winningNumbers, WINNING_NUMBER_SIZE)) {
            String message = String.format("당첨 번호는 %d개 입니다.", WINNING_NUMBER_SIZE);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateRange(List<Integer> winningNumbers) {
        if (!NumbersValidator.validateRange(winningNumbers, WINNING_NUMBER_MIN, WINNING_NUMBER_MAX)) {
            String message = String.format("당첨 번호의 범위는 [%d, %d] 입니다.", WINNING_NUMBER_MIN, WINNING_NUMBER_MAX);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        if (!NumbersValidator.validateDuplicate(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }
}
