package step2.domain;

import step2.domain.strategy.LottoPickStrategy;
import step2.domain.strategy.ManualPick;
import step2.domain.strategy.RandomPick;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<String> manualPick) {
        for (String pick : manualPick)
            lottos.add(new Lotto(new ManualPick(pick)));
    }

    public Lottos(int autoCount, LottoPickStrategy lottoPickStrategy) {
        for (int i = 0; i < autoCount; i++)
            lottos.add(new Lotto(lottoPickStrategy));
    }

    public int size() {
        return lottos.size();
    }

    public List<LottoNumber> numbers(int index) {
        return lottos.get(index).pick();
    }

    public LottoWinners match(List<LottoNumber> pickLottoNumberOfWeek, LottoNumber bonusBall) {
        LottoWinners lottoWinners = new LottoWinners();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.matching(pickLottoNumberOfWeek, bonusBall);
            lottoWinners.addWiners(rank);
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
