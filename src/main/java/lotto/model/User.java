package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {

    private final int count;
    private final List<Lotto> lottos;
    private Statistics statistics;

    public User(int count, LottoRules lottoRules) {
        this.count = count;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(lottoRules));
        }
        this.lottos = lottos;
        this.statistics = new Statistics();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<Rank, Integer> getRanks() {
        return Statistics.getRanks();
    }

    public void setRanks(WinningNumber winningNumber) {
        Statistics.setRanks(winningNumber, lottos);
    }

    public int getCount() {
        return count;
    }

}
