package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public Lottos(List<Lotto> manualLottos, List<Lotto> generatedLottos){
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(generatedLottos);

        this.lottos = lottos;
    }

    public List<Lotto> get() {
        return lottos;
    }
}