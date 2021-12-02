package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(int ticketsCount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < ticketsCount; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
