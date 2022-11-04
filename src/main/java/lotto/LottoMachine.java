package lotto;

import java.util.List;
import java.util.Map;

public class LottoMachine {
    private int canBuyLottoCount;

    public LottoMachine(Money money) {
        this.canBuyLottoCount = money.countBy(Lotto.PRICE);
    }

    public boolean canBuyLotto(int lottoCount) {
        return canBuyLottoCount >= lottoCount;
    }

    public Lottos buyLottoManually(List<List<Integer>> numbers) {
        if (numbers.size() > canBuyLottoCount) {
            return new Lottos();
        }
        canBuyLottoCount -= numbers.size();
        return new Lottos(numbers);
    }

    public Lottos buyLottoAuto() {
        Lottos lottos = new Lottos();
        for (int i = 0; i < canBuyLottoCount; i++) {
            lottos.add(Lotto.auto(new AutoLottoNumberPickStrategy()));
        }
        canBuyLottoCount = 0;
        return lottos;
    }

    public Statistic calculateStatistic(Money money, WinningLotto winningLotto, Lottos... lottoArray) {
        Lottos lottos = new Lottos();
        for (Lottos lotto : lottoArray) {
            lottos.addAll(lotto);
        }
        Map<Winning, Integer> matching = lottos.matching(winningLotto);
        return new Statistic(money, matching);
    }
}