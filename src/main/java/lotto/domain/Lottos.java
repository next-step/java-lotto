package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottoList() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getCount() {
        return lottos.size();
    }

    public int[] getTotalRank(Lotto winningLotto) {
        int[] totalLottoRank = new int[5];
        for (int i = 0; i < 5; i++) {
            totalLottoRank[i] = 0;
        }

        for (Lotto buyingLotto : lottos) {
            totalLottoRank[buyingLotto.getRank(winningLotto) - 1]++;
        }
        return totalLottoRank;
    }

    public int getTotalWinningMoney(Lotto winningLotto) {
        return WinningMoneyCalculator.getTotalWinningMoney(winningLotto, this);
    }
}
