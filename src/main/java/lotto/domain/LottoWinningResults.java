package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWinningResults {
    private static final int ZERO = 0;
    private final EnumMap<WinType, Integer> results = new EnumMap<>(WinType.class);

    public LottoWinningResults() {
        Arrays.stream(WinType.values())
                .forEach(it -> results.put(it, ZERO));
    }

    public Map<WinType, Integer> checkWinLotto(List<Lotto> lottos, String winNumbers) {
        Lotto winLotto = new Lotto(winNumbers);

        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchNumberCnt(winLotto);
            int existsWinCount = getWinCount(matchCount);
            results.put(WinType.getByCnt(matchCount), existsWinCount + 1);
        }

        return results;
    }

    private int getWinCount(int matchCnt) {
        if (results.get(WinType.getByCnt(matchCnt)) == null) {
            return ZERO;
        }
        return results.get(WinType.getByCnt(matchCnt));
    }
}
