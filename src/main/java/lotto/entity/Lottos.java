package lotto.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    public static final int MIN_MATCH_COUNT = 3;

    private final List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public List<Lotto> getValues() {
        return Collections.unmodifiableList(values);
    }

    public List<Integer> getMatchingCounts(Lotto winningLotto) {
        return values.stream()
                .map(lottoTicket -> lottoTicket.matchCount(winningLotto))
                .collect(Collectors.toList());
    }

    public Map<PrizePolicy, Integer> calculateWinLottoTicket(List<Integer> matchingLottoTickets, LottoNumber bonusBall) {
        Map<PrizePolicy, Integer> winLottoTicket = new HashMap<>();
        for (int i = 0; i < matchingLottoTickets.size(); i++) {
            int matchCount = matchingLottoTickets.get(i);
            Lotto lottoTicket = values.get(i);
            PrizePolicy prizePolicy = PrizePolicy.fromMatchCountAndBonus(matchCount, lottoTicket.containsBonusBall(bonusBall));
            winLottoTicket.put(prizePolicy, winLottoTicket.getOrDefault(prizePolicy, 0) + 1);
        }
        return winLottoTicket;
    }

    private static void inputWinLottoTicket(Map<PrizePolicy, Integer> winLottoTicket, Integer matchCount) {
        if (matchCount >= MIN_MATCH_COUNT) {
            PrizePolicy prizePolicy = PrizePolicy.fromMatchCount(matchCount);
            winLottoTicket.put(prizePolicy, winLottoTicket.getOrDefault(prizePolicy, 0) + 1);
        }
    }


}
