package lotto.backend.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoRank, Integer> values = new EnumMap<>(LottoRank.class);

    private LottoStatistics(WinningLotto winningLotto, LottoTickets lottoTickets) {
        initializeEnumMap();
        for (LottoTicket lottoTicket : lottoTickets.getValues()) {
            LottoRank rank = winningLotto.analysis(lottoTicket);
            this.values.computeIfPresent(rank, (k, v) -> v + 1);
        }
    }

    private void initializeEnumMap() {
        for (LottoRank lottoRank : LottoRank.values()) {
            values.put(lottoRank, 0);
        }
    }

    public static LottoStatistics of(WinningLotto winningLotto, LottoTickets lottoTickets) {
        return new LottoStatistics(winningLotto, lottoTickets);
    }

    public int prizeAmount() {
        return values.entrySet().stream()
                .mapToInt(i -> i.getKey().getMoneyPrize() * i.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getValues() {
        return Collections.unmodifiableMap(values);
    }
}
