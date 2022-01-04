package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lotto.utils.FixNumberStrategy;
import lotto.utils.NumberStrategy;
import lotto.utils.RandomNumberStrategy;

public class LottoGame {

    private List<Lotto> lottos;

    private static final NumberStrategy numberStrategy = new RandomNumberStrategy();

    public LottoGame(int number) {
        setLottos(number);
    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void setLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(numberStrategy));
        }
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoResult draw(Set<Integer> winningNumber, int bonusBall) {
        NumberStrategy numberStrategy = new FixNumberStrategy(new ArrayList<>(winningNumber));
        WinningLotto winningLotto = new WinningLotto(numberStrategy, bonusBall);
        return new LottoResult(winningLotto.matchResult(this.lottos));
    }

}
