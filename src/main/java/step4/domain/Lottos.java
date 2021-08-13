package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    private final int cost;

    public Lottos(int count, List<List<Integer>> manualLottoNums, int cost) {
        this.cost = cost;
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.createLotto());
        }
        for (List<Integer> manualLottoNum : manualLottoNums) {
            lottos.add(Lotto.createLotto(manualLottoNum));
        }        
    }

    public static Lottos createLottos(int count, int cost) {
        return new Lottos(count, new ArrayList<>(), cost);
    }

    public static Lottos createLottos(int count, List<List<Integer>> manualLottoNums, int cost) {
        return new Lottos(count, manualLottoNums, cost);
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
