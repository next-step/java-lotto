package lotto.domain;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by yusik on 2019/11/05.
 */
public class WinningNumbers {

    private static final int WINNING_NUMBER_MIN = 1;
    private static final int WINNING_NUMBER_MAX = 45;

    private final LotteryTicket winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {

        this.winningNumbers = new LotteryTicket(winningNumbers);

        validateBonusRange(bonusNumber);
        validateBonusDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningRanking, Long> getWinningTickets(List<LotteryTicket> tickets) {
        return tickets.stream()
                .filter(ticket -> ticket.isWin(winningNumbers.getNumbers(), bonusNumber))
                .collect(groupingBy(ticket -> ticket.getRanking(winningNumbers.getNumbers(), bonusNumber), counting()));
    }

    private void validateBonusRange(int bonusNumber) {
        if (bonusNumber < WINNING_NUMBER_MIN || bonusNumber > WINNING_NUMBER_MAX) {
            String message = String.format("보너스 번호의 범위는 [%d, %d] 입니다.", WINNING_NUMBER_MIN, WINNING_NUMBER_MAX);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateBonusDuplicate(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
