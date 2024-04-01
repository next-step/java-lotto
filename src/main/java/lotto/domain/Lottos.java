package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> createLottos(int count, NumberStrategy numberStrategy) {
        for (int i = 0; i < count; i++) {
            this.lottos.add(Lotto.createFromNumbers(numberStrategy.generateNumber()));
        }
        return this.lottos;
    }

    public List<Rank> match(String winningNumbers, int inputNumber) {
        List<Rank> ranks = new ArrayList<>();
        Lotto winningLotto = Lotto.createFromString(winningNumbers);
        LottoNumber bonusNumber = LottoNumber.of(inputNumber);
        for (Lotto lotto : lottos) {
            ranks.add(Rank.of(lotto.matchCount(winningLotto), lotto.isContains(bonusNumber)));
        }
        return ranks;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
