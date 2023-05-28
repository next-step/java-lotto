package model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos addLottos(Lottos inputLottos) {
        List<Lotto>allLotto = new ArrayList<>();
        allLotto.addAll(this.lottos);
        allLotto.addAll(inputLottos.getLottos());

        return new Lottos(allLotto);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

}
