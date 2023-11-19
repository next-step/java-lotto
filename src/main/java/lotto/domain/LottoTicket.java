package lotto.domain;

import java.util.*;

public class LottoTicket {
    private final List<Integer> ticket = new ArrayList<>();

    public LottoTicket(List<Integer> lottoNumber) {
        ticket.addAll(lottoNumber);
    }

    @Override
    public String toString() {
        return this.ticket.toString();
    }

    public boolean isThisNumberMatched(WinnerNumbers winnerNummbers, int i) {
        return winnerNummbers.isContain(ticket.get(i));
    }

    public int calculateTotalMatchedCount(WinnerNumbers winnerNummbers) {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            if (isThisNumberMatched(winnerNummbers, i)) {
                sum++;
            }
        }
        return sum;
    }
}
