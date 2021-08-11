package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;
    private Money money;
    private Map<LottoWinning, Integer> winningStatus;

    public Lottos(Money money, LottoNumbers numbers) {
        this.lottos = new ArrayList<>();
        this.money = money;
        this.winningStatus = new HashMap<>();

        int countOfLotto = getNumberOfPurchase();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(new Lotto(numbers));
        }
    }

    private int getNumberOfPurchase() {
        return money.getPurchaseMoney() / LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void checkLottosWinning(LottoNumbers lottoNumbers) {
        for (Lotto lotto : lottos) {
            LottoWinning winStats = LottoWinning.getWinningStatus(lotto.getMatchCount(lottoNumbers));
            setWinningStatus(winStats);
        }
    }

    private void setWinningStatus(LottoWinning winStats) {
        if (winStats != LottoWinning.FAIL) {
            winningStatus.put(winStats, winningStatus.getOrDefault(winStats, 0) + 1);
            money.plusReward(winStats.getReward());
        }
    }

    public Map<LottoWinning, Integer> getWinningStatus() {
        return winningStatus;
    }

    public Money getMoney() {
        return money;
    }

}
