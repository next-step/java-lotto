package lotto;

import java.util.Collections;
import java.util.List;

public class LastWinningNumbers {

    private final LottoTicket winningNumbers;
    private final Number bonusNumber;

    private LastWinningNumbers(LottoTicket winningNumbers, Number bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LastWinningNumbers newWinningNumbers(LottoTicket winningNumbers, Number bonusNumber) {
        return new LastWinningNumbers(winningNumbers, bonusNumber);
    }

    public int sumCountOfMatch(List<Number> ticketNumbers) {
        int countOfMatch = 0;

        for (Number winningNumber : winningNumbers.getTicket()) {
            countOfMatch = contains(ticketNumbers, countOfMatch, winningNumber);
        }

        return countOfMatch;
    }

    private int contains(List<Number> ticketNumbers, int countOfMatch, Number winningNumber) {
        if (ticketNumbers.contains(winningNumber)) {
            countOfMatch++;
        }

        return countOfMatch;
    }

    public boolean isMatchBonus(int countOfMatch, List<Number> ticketNumbers) {
        if (Rank.SECOND.equalsMatchCount(countOfMatch)) {
            return ticketNumbers.contains(bonusNumber);
        }

        return false;
    }

    public List<Number> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers.getTicket());
    }
}
