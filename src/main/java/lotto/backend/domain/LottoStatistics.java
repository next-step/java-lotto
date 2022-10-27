package lotto.backend.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoRank, Integer> values = new EnumMap<>(LottoRank.class);

    private LottoStatistics(LottoTicket winningLotto, LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getValues()) {
            int match = lottoTicket.countMatch(winningLotto);
            LottoRank rank = LottoRank.of(match);
            this.values.put(rank, values.getOrDefault(rank, 0) + 1);
        }
    }

    public static LottoStatistics of(LottoTicket winningLotto, LottoTickets lottoTickets) {
        return new LottoStatistics(winningLotto, lottoTickets);
    }

    public int prizeAmount() {
        return values.entrySet().stream()
                .mapToInt(i -> i.getKey().getPrize() * i.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getValues() {
        return Collections.unmodifiableMap(values);
    }
}
