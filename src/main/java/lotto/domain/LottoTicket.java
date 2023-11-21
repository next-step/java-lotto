package lotto.domain;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoTicket {
    private final Set<Integer> ticket = new HashSet<>();

    public LottoTicket(List<Integer> lottoNumber) {
        ticket.addAll(lottoNumber);
    }

    @Override
    public String toString() {
        return this.ticket.toString();
    }

    public boolean isThisNumberMatched(WinnerNumbers winnerNumbers, int number) {
        return winnerNumbers.isContain(number);
    }

    public boolean isMatchedWithBonusNum(WinnerNumbers winnerNumbers) {
        return ticket.contains(winnerNumbers.bonusNumber());
    }

    public int calculateTotalMatchedCount(WinnerNumbers winnerNumbers) {
        AtomicInteger sum = new AtomicInteger(0);

        ticket.iterator().forEachRemaining(number -> {

            if (isThisNumberMatched(winnerNumbers, number)) {
                sum.getAndIncrement();
            }
        });

        if (sum.get() == 5 && isMatchedWithBonusNum(winnerNumbers)) {
            return 50;
        }

        return sum.get();
    }
}
