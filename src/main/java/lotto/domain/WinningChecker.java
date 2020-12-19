package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningChecker {
    private static final int ZERO = 0;
    private final EnumMap<WinType, Integer> results = new EnumMap<>(WinType.class);

    public WinningChecker() {
        Arrays.stream(WinType.values())
                .forEach(it -> results.put(it, ZERO));
    }

    public Map<WinType, Integer> checkWinLotto(Lottos lottos, String winNumbers, LottoNumber bonusNumber) {
        Lotto winLotto = new Lotto(winNumbers);
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = lotto.matchNumberCnt(winLotto);
            boolean matchBonus = lotto.haNumber(bonusNumber);
            int existsWinCount = getWinCount(matchCount, matchBonus);
            results.put(WinType.valueOf(matchCount, matchBonus), existsWinCount + 1);
        }
        return results;
    }

    private int getWinCount(int matchCnt, boolean matchBonus) {
        if (results.get(WinType.valueOf(matchCnt, matchBonus)) == null) {
            return ZERO;
        }
        return results.get(WinType.valueOf(matchCnt, matchBonus));
    }
}
