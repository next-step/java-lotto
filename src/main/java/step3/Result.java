package step3;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Result {

    private final Lottos lottos;
    private final Map<Operator, Integer> map = new TreeMap<>() {{
        put(Operator.NOT_RANK, 0);
        put(Operator.THREE, 0);
        put(Operator.FOUR, 0);
        put(Operator.FIVE, 0);
        put(Operator.FIVE_BONUS, 0);
        put(Operator.SIX, 0);
    }};

    public Result(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> lottoList() {
        return lottos.getLottos();
    }

    public Map<Operator, Integer> results(WinningLotto bonusLotto) {
        for (Lotto lotto : lottoList()) {
            result(lotto, bonusLotto);
        }
        return map;
    }

    private void result(Lotto lotto, WinningLotto bonusLotto) {
        int count = checkRank(lotto, bonusLotto);
        Operator rank = Operator.find(count, bonusLotto.checkBonus(lotto));
        if (rank == null) {
            return;
        }
        map.put(rank, map.get(rank) + 1);
    }

    private int checkRank(Lotto lotto, WinningLotto bonusLotto) {
        return this.lottos.results(lotto, bonusLotto);
    }
}
