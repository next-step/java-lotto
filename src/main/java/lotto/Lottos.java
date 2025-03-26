package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public Map<Division, Integer> compareNumbers(Lotto comparingLotto) {
        for (Lotto lotto: lottos) {
            Division division = lotto.compareNumbers(comparingLotto);
        }
        return Division.getMatchCountMap();
    }
}
