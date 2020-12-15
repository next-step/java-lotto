package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWinningChecker {
    private static final int ZERO = 0;

    public Map<WinType, Integer> checkWin(List<Lotto> lottos, String winNumbers) {
        Lotto winLotto = new Lotto(winNumbers);
        Map<WinType, Integer> results = new EnumMap<>(WinType.class);
        for(Lotto lotto: lottos) {
            int matchNumberCnt = lotto.matchNumberCnt(winLotto);
            int existsWinCount = getWinCount(results, matchNumberCnt);
            results.put(WinType.getByCnt(matchNumberCnt), existsWinCount + 1);
        }
        return results;
    }

    private int getWinCount(Map<WinType, Integer> results, int matchNumberCnt) {
        if(results.get(WinType.getByCnt(matchNumberCnt)) == null) {
            return ZERO;
        }
        return results.get(WinType.getByCnt(matchNumberCnt));
    }
}
