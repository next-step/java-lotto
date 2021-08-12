package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private List<Lotto> lottos;
    private LottoRandomNumbers lottoNumbers;
    private Map<LottoResult, Integer> winningStatus;

    public Lottos(int purchaseQuantity) {
        lottos = new ArrayList<>();
        winningStatus = new HashMap<>();
        lottoNumbers = new LottoRandomNumbers();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void checkLottosWinning(Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            LottoResult winStats = LottoResult.getWinningStatus(lotto.getMatchCount(winningLotto));
            setWinningStatus(winStats);
        }
    }

    private void setWinningStatus(LottoResult winStats) {
        if (winStats != LottoResult.FAIL) {
            winningStatus.put(winStats, winningStatus.getOrDefault(winStats, 0) + 1);
            LottoShop.getMoney().plusReward(winStats.getReward());
        }
    }

    public Map<LottoResult, Integer> getWinningStatus() {
        return winningStatus;
    }


}
