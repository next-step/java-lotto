package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {
    
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(NumberCreationStrategy strategy) {
        this(to(strategy.getNumbers()));
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private static List<LottoTicket> to(List<List<Integer>> numbers) {
        return numbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    public Map<LottoRank, Integer> calculateSameNumberCounts(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        Map<LottoRank, Integer> counts = new HashMap<>();
        for (LottoTicket ticket : lottoTickets) {
            LottoRank lottoRank = LottoRank.valueOf(
                    ticket.calculateSameNumberCount(lottoTicket),
                    ticket.hasNumber(bonusNumber));
            calculateSameNumberCount(counts, lottoRank);
        }
        return counts;
    }

    private void calculateSameNumberCount(Map<LottoRank, Integer> counts, LottoRank lottoRank) {
        if (counts.containsKey(lottoRank)) {
            counts.put(lottoRank, counts.get(lottoRank) + 1);
            return;
        }
        counts.put(lottoRank, 1);
    }

    public void addLottoTickets(NumberCreationStrategy strategy) {
        lottoTickets.addAll(to(strategy.getNumbers()));
    }

    public int getSize() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoNumbers() {
        return lottoTickets;
    }
}
