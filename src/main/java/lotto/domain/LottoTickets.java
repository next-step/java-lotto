package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.RateCalculator;

public class LottoTickets {
    private List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public Map<Integer, Integer> winningCheck(List<Integer> winningNumbers) {
        Map<Integer, Integer> result = new HashMap<>();
        for (LottoTicket ticket : tickets) {
            int count = ticket.winningCount(winningNumbers);
            result.put(count, result.getOrDefault(count, 0) + 1);
        }
        return result;
    }

    private int totalPrice() {
        return tickets.size()*LottoMachine.LOTTO_PRICE;
    }

    public double profitRate(Map<Integer, Integer> winningResult) {
        return RateCalculator.calculateProfitRate(winningResult, totalPrice());
    }
}
