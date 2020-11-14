package step3.domain.lotto;

import step3.domain.lotto.firstcollection.LottoNumber;
import step3.domain.lotto.firstcollection.LottoTickets;
import step3.domain.lotto.firstcollection.MarkingNumbers;
import step3.domain.lotto.firstcollection.WinningResults;
import step3.type.WinningType;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static step3.Constant.ERROR_DUPLICATE_NUMBER;

public class WinningNumbers {
    private static final String DELIMITER = ",";
    private static final int REVENUE_ANCHOR_POINT = 1;

    private final MarkingNumbers winningNumbers;
    private final LottoNumber bonusBall;

    private WinningNumbers(MarkingNumbers winningNumbers, LottoNumber bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public static WinningNumbers of(String string, int bonusBall) {
        isValid(string);
        MarkingNumbers winningNumbers = stringToObj(string);
        isDuplicate(bonusBall, winningNumbers);
        return new WinningNumbers(winningNumbers, new LottoNumber(bonusBall));
    }

    private static MarkingNumbers stringToObj(String string) {
        Set<LottoNumber> collect = Stream.of(string.split(DELIMITER))
                .map(value -> {
                    String trim = value.trim();
                    return new LottoNumber(Integer.parseInt(trim));
                })
                .collect(Collectors.toSet());
        return new MarkingNumbers(collect);
    }

    public static WinningNumbers of(Set<LottoNumber> list, int bonusBall) {
        isValid(list);
        MarkingNumbers winningNumbers = new MarkingNumbers(list);
        isDuplicate(bonusBall, winningNumbers);
        return new WinningNumbers(winningNumbers, new LottoNumber(bonusBall));
    }

    private static void isDuplicate(int number, MarkingNumbers markingNumbers) {
        if (markingNumbers.contains(new LottoNumber(number))) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }

    public double getRevenueRate(LottoTickets tickets) {
        WinningResults winningResults = getWinningStatistics(tickets);
        return winningResults.getRevenue(tickets.countTicket());
    }

    public WinningType getWinningStatistics(LottoTicket ticket) {
        return WinningResults.compareWinningNumber(ticket, this);
    }

    public WinningResults getWinningStatistics(LottoTickets tickets) {
        return WinningResults.of(tickets, this);
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    public int countEquals(LottoTicket ticket) {
        return winningNumbers.countEquals(ticket);
    }

    public boolean isRevenue(double revenueRate) {
        return revenueRate > REVENUE_ANCHOR_POINT;
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
            throw new IllegalArgumentException();
        }
    }

}
