package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LottoBundle {

    private final List<LottoNumbers> tickets;

    public LottoBundle(List<LottoNumbers> tickets) {
        this.tickets = tickets;
    }

    public int count() {
        return tickets.size();
    }

    public LottoResult drawing(LottoNumbers winningNumbers) {
        return new LottoResult(groupinbByPrize(winningNumbers));
    }

    private Map<Prize, Integer> groupinbByPrize(LottoNumbers winningNumbers) {
        Map<Prize, List<LottoNumbers>> ticketsPerPrize = tickets.stream()
                .collect(groupingBy(lottoNumbers -> lottoNumbers.matchNumbers(winningNumbers)));
        return ticketsPerPrize.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }

    public List<LottoNumbers> getTickets() {
        return tickets;
    }
}
