package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private Map<Rank, Integer> lottoStatistics;
    public LottoStatistics(LottoTicket lottoTicket, LottoMachine lottoMachine, Lotto winningLotto) {
        this.lottoStatistics = new HashMap<>();
        init();
        generateStatistics(lottoTicket, lottoMachine, winningLotto);
    }

    public Map<Rank, Integer> getLottoStatistics() {
        return Collections.unmodifiableMap(lottoStatistics);
    }

    private void generateStatistics(LottoTicket lottoTicket, LottoMachine lottoMachine, Lotto winningLotto) {
        for (Lotto lotto: lottoTicket.getLottoTicket()) {
            Rank rank = lottoMachine.rank(lotto, winningLotto);
            if (lottoStatistics.containsKey(rank)) {
                int money = lottoStatistics.get(rank) + 1;
                lottoStatistics.replace(rank, money);
            }
        }
    }
    private void init() {
        lottoStatistics.put(Rank.FOURTH, 0);
        lottoStatistics.put(Rank.THIRD, 0);
        lottoStatistics.put(Rank.SECOND, 0);
        lottoStatistics.put(Rank.FIRST, 0);
    }
}
