package step2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<Integer, Integer> result = new HashMap<>();

    public LottoResult(List<LottoTicket> tickets, LottoTicket winningTicket) {

        result(tickets, winningTicket);

    }

    public LottoResult(Map<Integer, Integer> result) {
        this.result = result;
    }

    public void result(List<LottoTicket> tickets, LottoTicket winningTicket) {

        result = tickets.stream()
                .map(ticket -> ticket.winningCount(winningTicket)).
                collect(Collectors.groupingBy(Integer::intValue, Collectors.summingInt(e -> 1)));
        postProcess();

    }
    
    private void postProcess() {
        for (int i = 0; i <= 6; i++) {
            result.putIfAbsent(i, 0);
        }
    }

    public int countOfMatch( int match) {
        return result.get(match);
    }
}
