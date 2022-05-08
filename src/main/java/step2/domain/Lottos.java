package step2.domain;

import step2.controller.ManualPick;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<String> manualPick, int autoCount) {
        for (String pick : manualPick)
            lottos.add(new Lotto(new ManualPick(pick)));

        for (int i = 0; i < autoCount; i++)
            lottos.add(new Lotto(new RandomPick()));
    }

    public int size() {
        return lottos.size();
    }

    public List<LottoNumber> numbers(int index) {
        return lottos.get(index).pick();
    }

    public LottoWinners match(List<Integer> pickLottoNumberOfWeek, int bonusBall) {
        LottoWinners lottoWinners = new LottoWinners();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.matching(pickLottoNumberOfWeek, bonusBall);
            lottoWinners.addWiners(rank);
        }

        return lottoWinners;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
