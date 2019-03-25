package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Integer> ticket;

    public LottoTicket() {
        ticket = LottoGenerator.createLottoNumbers();
    }

    public List<Integer> getTicket() {
        return this.ticket;
    }

    @Override
    public String toString() {
        List<String> newTicket = new ArrayList<String>();
        for (Integer number : ticket) {
            newTicket.add(String.valueOf(number));
        }

        String tickets = String.join(", ", newTicket);
        return "[" + tickets + "]";
    }
}
