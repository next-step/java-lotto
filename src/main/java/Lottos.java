import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < price / 1000; i++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Map<Integer, Integer> rank(Lotto winningLotto) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Lotto lotto : lottos) {
            Integer rank = lotto.rank(winningLotto);
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
        return map;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }
}
