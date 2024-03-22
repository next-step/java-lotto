package lotto.domain;

import common.view.ResultView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public void showTickets(){
        for (LottoTicket ticket : tickets) {
            ResultView.showTicketNumber(ticket.getNumbers());
        }
    }

    private Map<Integer, Integer> winningCheck(List<Integer> winningNumbers) {
        Map<Integer, Integer> result = new HashMap<>();
        for (LottoTicket ticket : tickets) {
            ticket.compareWithWinningNumbers(winningNumbers);
            int count = ticket.getWinningCount();
            result.put(count, result.getOrDefault(count, 0) + 1);
        }
        return result;
    }
    private double calculateProfitRate(Map<Integer, Integer> winningMap) {
        long totalWinningAmount = 0;
        totalWinningAmount += winningMap.getOrDefault(3, 0) * 5000L;
        totalWinningAmount += winningMap.getOrDefault(4, 0) * 50000L;
        totalWinningAmount += winningMap.getOrDefault(5, 0) * 1500000L;
        totalWinningAmount += winningMap.getOrDefault(6, 0) * 2000000000L;

        return (double) totalWinningAmount / (tickets.size()*LottoMachine.LOTTO_PRICE);
    }
    public void showResult(List<Integer> winningNumbers){
        Map<Integer, Integer> winningResult = winningCheck(winningNumbers);
        double rate = calculateProfitRate(winningResult);
        ResultView.printResult(winningResult, rate);
    }
}
