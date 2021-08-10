package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;
    private Money money;
    private Map<LottoWinning, Integer> lottosWinningStatus;

    public Lottos(Money money, LottoNumbers numbers) {
        this.lottos = new ArrayList<>();
        this.money = money;
        this.lottosWinningStatus = new HashMap<>();

        int countOfLotto = money.getPurchaseMoney() / 1000;
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void checkLottosWinning(LottoNumbers lottoNumbers) {
        for (Lotto lotto : lottos) {
            LottoWinning winStats = LottoWinning.getWinningStatus(lotto.getMatchCount(lottoNumbers));
            setLottosWinningStatus(winStats);
        }
    }

    private void setLottosWinningStatus(LottoWinning winStats) {
        if (winStats != LottoWinning.FAIL) {
            lottosWinningStatus.put(winStats, lottosWinningStatus.getOrDefault(winStats, 0) + 1);
            money.plusReward(winStats.getReward());
        }
    }

    public Map<LottoWinning, Integer> getLottosWinningStatus() {
        return this.lottosWinningStatus;
    }

    public Money getMoney() {
        return this.money;
    }

}
