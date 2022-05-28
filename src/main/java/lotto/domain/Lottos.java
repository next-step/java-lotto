package lotto.domain;

import java.util.*;

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

    public int getTotalWinningMoney(WinningLotto winningLotto) {
        return WinningMoneyCalculator.getTotalWinningMoney(winningLotto, this);
    }
}
