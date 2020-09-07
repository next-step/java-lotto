package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoBundle {

    private final List<LottoNumbers> tickets;

    public LottoBundle(List<LottoNumbers> tickets) {
        this.tickets = tickets;
    }

    public int count() {
        return tickets.size();
    }

    public LottoResult drawing(WinningLotto winningNumbers) {
        Map<Prize, Integer> result = countByPrize(winningNumbers.matching(tickets));
        return new LottoResult(result);
    }

    private Map<Prize, Integer> countByPrize(Map<Prize, List<LottoNumbers>> ticketsPerPrize) {
        return ticketsPerPrize.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }

    public List<LottoNumbers> getTickets() {
        return tickets;
    }
}
