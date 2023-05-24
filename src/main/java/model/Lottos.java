package model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(Lottos leftLottos, Lottos rightLottos) {
        this.lottos.addAll(leftLottos.getLottos());
        this.lottos.addAll(rightLottos.getLottos());
    }

    public Lottos addLottos(Lottos inputLottos) {
        this.lottos.addAll(inputLottos.getLottos());
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
