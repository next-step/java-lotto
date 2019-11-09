package lotto.domain;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by yusik on 2019/11/05.
 */
public class WinningNumbers {

    private final LotteryTicket winningNumbers;
    private final LotteryNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = LotteryTicket.from(winningNumbers);
        LotteryNumber bonus = LotteryNumber.of(bonusNumber);
        validateDuplicate(bonus);
        this.bonusNumber = bonus;
    }

    public Map<WinningRanking, Long> getWinningTickets(List<LotteryTicket> tickets) {
        return tickets.stream()
                .filter(ticket -> ticket.isWin(winningNumbers, bonusNumber))
                .collect(groupingBy(ticket -> ticket.getRanking(winningNumbers, bonusNumber), counting()));
    }

    private void validateDuplicate(LotteryNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 복권 번호와 중복될 수 없습니다.");
        }
    }
}
