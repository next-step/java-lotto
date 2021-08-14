package lotto.domain;

import lotto.strategy.RandomLottoNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private List<Lotto> lottos;
    private Map<LottoResult, Integer> winningStatus;

    public Lottos(int purchaseQuantity) {
        lottos = new ArrayList<>();
        winningStatus = new HashMap<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottos.add(Lotto.of(RandomLottoNumber.generateRandomNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void checkLottosWinning(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean matchBonus = lotto.getMatchBonus(winningLotto);
            LottoResult lottoResult = LottoResult.getLottoResult(matchCount, matchBonus);
            setWinningStatus(lottoResult);
        }
    }

    private void setWinningStatus(LottoResult lottoResult) {
        if (lottoResult != LottoResult.FAIL) {
            winningStatus.put(lottoResult, winningStatus.getOrDefault(lottoResult, 0) + 1);
            LottoShop.getMoney().plusReward(lottoResult.getReward());
        }
    }

    public Map<LottoResult, Integer> getWinningStatus() {
        return winningStatus;
    }


}
