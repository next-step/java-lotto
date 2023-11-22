package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<Integer, Integer> result = new HashMap<>();
    public static final int LOTTO_MATCH_MIN=0;
    public static final int LOTTO_MATCH_MAX=6;

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
        for (int i = LOTTO_MATCH_MIN; i <= LOTTO_MATCH_MAX; i++) {
            result.putIfAbsent(i, 0);
        }
    }

    public int countOfMatch( int match) {
        return result.get(match);
    }
}
