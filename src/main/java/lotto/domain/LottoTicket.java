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

    public boolean isThisNumberMatched(WinnerNumbers winnerNummbers, int number) {
        return winnerNummbers.isContain(number);
    }

    public int calculateTotalMatchedCount(WinnerNumbers winnerNummbers) {
        AtomicInteger sum = new AtomicInteger(0);

        ticket.iterator().forEachRemaining(number -> {

            if (isThisNumberMatched(winnerNummbers, number)) {
                sum.getAndIncrement();
            }
        });

        return sum.get();
    }
}
