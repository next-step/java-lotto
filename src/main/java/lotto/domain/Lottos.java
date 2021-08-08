package lotto.domain;

import lotto.strategy.ListSortOrMixStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public void drawLottos(LottoNumbers winnerNumbers) {
        for (Lotto lotto : lottos) {
            lotto.drawLotto(winnerNumbers);
        }
    }

    public long countWinners(Award award) {
        return lottos.stream().filter(lotto -> lotto.isWinner(award)).count();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
