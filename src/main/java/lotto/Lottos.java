package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int numberOfLotto() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoRank, Integer> getWinningResult(WinningLotto winningLotto) {
        Map<LottoRank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank rank = LottoRank.isLottoRank(lotto.countMatch(winningLotto));
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    @Override
    public String toString() {
        return "[" +
            lottos +
            ']';
    }
}
