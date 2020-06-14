package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoSheet {

    private List<UserLotto> lottos;

    public LottoSheet() {
        this.lottos = new ArrayList<>();
    }

    public LottoSheet(List<UserLotto> lottos) {
        this.lottos = lottos;
    }

    public List<UserLotto> getLottos() {
        return lottos;
    }

    public Map<Prize, Integer> getPrizeResult(WinningLotto winningLotto) {
        Map<Prize, Integer> prizeResult = new HashMap<>();
        lottos.forEach(lottos -> {
            Prize prize = lottos.getPrize(winningLotto);
            prizeResult.put(prize, prizeResult.getOrDefault(prize, 0) + 1);
        });

        return prizeResult;
    }

    @Override
    public String toString() {
        return "LottoSheet{" +
            "lottos=" + lottos +
            '}';
    }
}
