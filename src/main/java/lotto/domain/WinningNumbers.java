package lotto.domain;

import lotto.util.NumbersValidator;

import java.util.List;
import java.util.Map;

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
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningRanking, Long> getWinningTickets(List<LotteryTicket> tickets) {
        return tickets.stream()
                .filter(ticket -> WinningRanking.MISS != ticket.getRanking(winningNumbers, bonusNumber))
                .collect(groupingBy(ticket -> ticket.getRanking(winningNumbers, bonusNumber), counting()));
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateRange(winningNumbers);
        validateDuplicate(winningNumbers);
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusRange(bonusNumber);
        validateBonusDuplicate(bonusNumber);
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
