package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoResult {
    private final LottoStatistics lottoStatistics = new LottoStatistics();
    private final List<Lotto> lottoResult = new ArrayList<>();

    public List<Lotto> getLottoResults() {
        return Collections.unmodifiableList(lottoResult);
    }

    public int size() {
        return lottoResult.size();
    }

    public void calculateLotto(WinningNumber winningNumber) {
        for (Lotto lotto : lottoResult) {
            int matchCount = winningNumber.matchNumberCount(lotto);
            lottoStatistics.incrementMatchCount(matchCount);
        }
    }

    public int getCountByMatchCount(int matchCount) {
        return lottoStatistics.getCountByMatchCount(matchCount);
    }

    public int getPrizeMoneyByMatchCount(int matchCount) {
        return lottoStatistics.getPrizeMoneyByMatchCount(matchCount);
    }

    public int getEarningsByMatchCount(int matchCount) {
        return lottoStatistics.getEarningsByMatchCount(matchCount);
    }

    public void addLotto(Lotto lotto) {
        this.lottoResult.add(lotto);
    }
}
