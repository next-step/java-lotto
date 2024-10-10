package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(new LottoAutoStrategy()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> calculatorWinning(Lotto winingLotto) {
        HashMap<Rank, Integer> result = new HashMap<>();
        lottos.forEach(lotto -> {
            int winningCount = lotto.countMatchingNumbers(winingLotto);
            Rank rank = Rank.from(winningCount);
            result.merge(rank, 1, (v1, v2) -> v1 + v2);
        });

        return result;
    }
}
