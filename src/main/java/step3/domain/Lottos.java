package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    private final int cost;

    public Lottos(int count, int cost) {
        this.cost = cost;
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.createLotto());
        }
    }

    public static Lottos createLottos(int count, int cost) {
        return new Lottos(count, cost);
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getTotalCost() {
        return cost;
    }
}
