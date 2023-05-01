package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    
    private final List<LottoTicket> lottoTickets;
    private NumberCreationStrategy strategy;

    public LottoTickets(List<LottoTicket> lottoTickets, NumberCreationStrategy strategy) {
        this.lottoTickets = lottoTickets;
        this.strategy = strategy;
    }

    public LottoTickets(int lottoCount, NumberCreationStrategy strategy) {
        this.strategy = strategy;
        this.lottoTickets = createLottoNumbers(lottoCount);
    }

    private List<LottoTicket> createLottoNumbers(int lottoCount) {
        List<LottoTicket> numbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            numbers.add(new LottoTicket(strategy));
        }
        return numbers;
    }

    public Map<LottoRank, Integer> calculateSameNumberCounts(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        Map<LottoRank, Integer> counts = new HashMap<>();
        for (LottoTicket ticket : lottoTickets) {
            calculateOneStage(lottoTicket, counts, ticket, bonusNumber);
        }
        return counts;
    }

    private void calculateOneStage(LottoTicket lottoTicket,
                                   Map<LottoRank, Integer> counts,
                                   LottoTicket ticket,
                                   LottoNumber bonusNumber) {
        LottoRank lottoRank = LottoRank.valueOf(
                ticket.calculateSameNumberCount(lottoTicket),
                ticket.hasNumber(bonusNumber));
        if (counts.containsKey(lottoRank)) {
            counts.put(lottoRank, counts.get(lottoRank) + 1);
            return;
        }
        counts.put(lottoRank, 1);
    }

    public List<LottoTicket> getLottoNumbers() {
        return lottoTickets;
    }
}
