package lottoauto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoReport {

    private int lottoCount = 0;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<LottoStatus, Integer> winningMap = new HashMap<>();
    private long profitRate;

    public LottoReport(){}

    public long getProfitRate() {
        return profitRate;
    }

    public Map<LottoStatus, Integer> getWinningMap() {
        return new HashMap<>(winningMap);
    }

    public void reportLottoCount(Map<LottoStatus, Integer> winningMap) {
        this.winningMap = winningMap;
    }

    public void reportLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void reportProfitRate(long profitRate) {
        this.profitRate = profitRate;
    }
}
