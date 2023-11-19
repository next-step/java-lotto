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
    public List<Integer> ticket() {
        return this.ticket;
    }

    public boolean isThisNumberMatched(List<Integer> winnerNummbers, int i) {
        return winnerNummbers.contains(ticket.get(i));
    }
}
