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

    public List<Lotto> createManualLotto(List<String> manualLottos) {
        for (String lotto : manualLottos) {
            this.lottos.add(Lotto.createFromString(lotto));
        }
        return this.lottos;
    }

    public List<Lotto> addAllLotto(Lottos otherLottos) {
        List<Lotto> combineLotto = new ArrayList<>(this.lottos);
        combineLotto.addAll(otherLottos.getLottos());
        return combineLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int lottoSize() {
        return lottos.size();
    }
}
