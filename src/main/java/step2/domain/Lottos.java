package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final LottoStatistics lottoStatistics = new LottoStatistics();
    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public void calculateLotto(WinningNumber winningNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = winningNumber.matchNumberCount(lotto);
            lottoStatistics.incrementMatchCount(matchCount);
        }
    }

    public int getCountByMatchCount(int matchCount) {
        return lottoStatistics.getCountByMatchCount(matchCount);
    }

    public int getPrizeMoneyByMatchCount(int matchCount) {
        return lottoStatistics.getPrizeMoney(matchCount);
    }

    public int getEarningsByMatchCount(int matchCount) {
        return lottoStatistics.getEarningsByMatchCount(matchCount);
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
