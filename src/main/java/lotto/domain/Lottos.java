package lotto.domain;

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
            boolean bonusMatched = lotto.checkBonusNumber(winningNumber);
            lottoStatistics.incrementMatchCount(matchCount, bonusMatched);
        }
    }

    public int getCountByMatchCount(int matchCount, boolean bonusMatched) {
        return lottoStatistics.getCountByMatchCount(matchCount, bonusMatched);
    }

    public int getCountByMatchCount(int matchCount) {
        return lottoStatistics.getCountByMatchCount(matchCount, false);
    }

    public int getPrizeMoneyByMatchCount(int matchCount, boolean bonusMatched) {
        return lottoStatistics.getPrizeMoney(matchCount, bonusMatched);
    }

    public int getPrizeMoneyByMatchCount(int matchCount) {
        return lottoStatistics.getPrizeMoney(matchCount, false);
    }

    public int getEarningsByMatchCount(int matchCount, boolean bonusMatched) {
        return lottoStatistics.getEarningsByMatchCount(matchCount, bonusMatched);
    }

    public int getEarningsByMatchCount(int matchCount) {
        return lottoStatistics.getEarningsByMatchCount(matchCount, false);
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
