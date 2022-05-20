package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottos);
    }

    public int getCount() {
        return lottos.size();
    }

    public int[] getTotalRank(WinningLotto winningLotto) {
        int[] totalLottoRank = new int[5];
        for (int i = 0; i < 5; i++) {
            totalLottoRank[i] = 0;
        }

        for (Lotto buyingLotto : lottos) {
            totalLottoRank[buyingLotto.getRank(winningLotto).ordinal() - 1]++;
        }
        return totalLottoRank;
    }

    public int getTotalWinningMoney(WinningLotto winningLotto) {
        return WinningMoneyCalculator.getTotalWinningMoney(winningLotto, this);
    }
}
