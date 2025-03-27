package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int count) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            lottos.add(Lotto.createQuickPick());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottos.size(); ++i) {
            this.lottos.add(lottos.get(i));
        }
    }

    public Map<Division, Integer> compareNumbers(Lotto comparingLotto) {
        for (Lotto lotto: lottos) {
            Division division = lotto.compareNumbers(comparingLotto);
        }
        return Division.getMatchCountMap();
    }

    public int size() {
        return lottos.size();
    }

    public List<List<Integer>> getLottos() {
        List<List<Integer>> returnLottos = new ArrayList<>();
        for (Lotto lotto: lottos) {
            returnLottos.add(lotto.getNumbers());
        }
        return returnLottos;
    }
}
