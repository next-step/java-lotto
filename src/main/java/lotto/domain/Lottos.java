package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static lotto.view.InputView.generateNumbers;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void generateLottoNumbers(NumbersGenerator generator, int amount) {
        for (int i = 0; i < amount; i++) {
            Lotto newLotto = new Lotto(generator.generate());
            this.lottos.add(newLotto);
        }
    }

    public void saveMatchResult(WinningLotto winningLotto, Match match) {
        this.lottos.forEach(iter -> {
            winningLotto.saveMatchInfo(iter, match);
        });
    }

    public List<Lotto> getLottoNumbers() {
        return lottos;
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
