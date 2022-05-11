package step2.domain;

import step2.domain.strategy.ManualPick;
import step2.domain.strategy.RandomPick;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(PurchaseLotto input) {
        manaualLottos(input);
        autoLottos(input);
    }

    private void manaualLottos(PurchaseLotto input) {
        for (String pick : input.getManualPick())
            lottos.add(new Lotto(new ManualPick(pick)));
    }

    private void autoLottos(PurchaseLotto input) {
        for (int i = 0; i < input.getAutoCount(); i++)
            lottos.add(new Lotto(new RandomPick()));
    }

    public int size() {
        return lottos.size();
    }

    public List<LottoNumber> numbers(int index) {
        return lottos.get(index).pick();
    }

    public LottoWinners match(LottoWeeklyNumber lottoWeeklyNumber) {
        LottoWinners lottoWinners = new LottoWinners();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.matching(lottoWeeklyNumber);
            lottoWinners.add(rank);
        }
        return lottoWinners;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void add(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
    }
}
