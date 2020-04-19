package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoSeller {

    private static final int LOTTO_PRISE = 1000;

    public static List<Lotto> buy(int money) {
        int buyCount = money / LOTTO_PRISE;
        if (buyCount < 1) {
            throw new IllegalArgumentException("돈이 모자랍니다");
        }
        return LottoMachine.generate(buyCount);
    }

    public static Map<Match, Integer> match(List<Lotto> lottos, Lotto winningLotto) {
        Map<Match, Integer> result = initResult();
        for (Lotto lotto : lottos) {
            Match match = Match.valueOf(winningLotto.match(lotto));
            result.put(match, result.get(match) + 1);
        }

        // TODO: compare
        return result;
    }

    private static Map<Match, Integer> initResult() {
        Map<Match, Integer> init = new HashMap<>();
        for (Match value : Match.values()) {
            init.put(value, 0);
        }
        return init;
    }

}
