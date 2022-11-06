package lotto.backend.domain;

import java.util.Collections;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoRank, Integer> values;


    private LottoStatistics(WinningLotto winningLotto, LottoTickets lottoTickets) {
        this.values = winningLotto.analysis(lottoTickets);
    }

    public static LottoStatistics of(WinningLotto winningLotto, LottoTickets lottoTickets) {
        return new LottoStatistics(winningLotto, lottoTickets);
    }

    public Money prizeAmount() {
        int prizeAmount = values.entrySet().stream()
                .mapToInt(i -> i.getKey().getMoneyPrize() * i.getValue())
                .sum();
        return new Money(prizeAmount);
    }

    public Map<LottoRank, Integer> getValues() {
        return Collections.unmodifiableMap(values);
    }
}
