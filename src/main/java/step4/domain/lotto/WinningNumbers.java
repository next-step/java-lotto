package step4.domain.lotto;

import step4.Constant;
import step4.domain.lotto.firstcollection.LottoNumber;
import step4.domain.lotto.firstcollection.LottoTickets;
import step4.domain.lotto.firstcollection.MarkingNumbers;
import step4.domain.lotto.firstcollection.WinningResults;
import step4.exception.DuplicateNumberException;

import java.util.Objects;
import java.util.Set;

import static step3.Constant.ERROR_DUPLICATE_NUMBER;

public class WinningNumbers {

    private final MarkingNumbers winningNumbers;
    private final LottoNumber bonusBall;

    private WinningNumbers(MarkingNumbers winningNumbers, LottoNumber bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public static WinningNumbers of(String string, int bonusBall) {
        isValid(string);
        MarkingNumbers winningNumbers = MarkingNumbers.of(string);
        isDuplicate(bonusBall, winningNumbers);
        return new WinningNumbers(winningNumbers, new LottoNumber(bonusBall));
    }

    public static WinningNumbers of(Set<LottoNumber> list, int bonusBall) {
        isValid(list);
        MarkingNumbers winningNumbers = new MarkingNumbers(list);
        isDuplicate(bonusBall, winningNumbers);
        return new WinningNumbers(winningNumbers, new LottoNumber(bonusBall));
    }

    private static void isDuplicate(int number, MarkingNumbers markingNumbers) {
        if (markingNumbers.contains(new LottoNumber(number))) {
            throw new DuplicateNumberException(ERROR_DUPLICATE_NUMBER);
        }
    }

    public WinningResults getWinningStatistics(LottoTickets tickets) {
        return WinningResults.of(tickets, this);
    }

    public int countEquals(LottoTicket ticket) {
        return winningNumbers.countEquals(ticket);
    }


    public boolean isMarkedBonusBall(LottoTicket ticket) {
        return ticket.isMarked(bonusBall);
    }
    private static void isValid(String string) {
        if (Objects.isNull(string) || string.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValid(Set<LottoNumber> list) {
        if (list.isEmpty() || list.size() < 6) {
            throw new IllegalArgumentException(Constant.ERROR_INVALID_PARAMETER);
        }
    }
}
