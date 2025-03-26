package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int count) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            lottos.add(new Lotto());
        }
    }

    public Lottos(int count, List<Lotto> lottos) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            this.lottos.add(lottos.get(i));
        }
    }
}
