package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningResultReader {
    private static final int ZERO = 0;
    private final EnumMap<WinType, Integer> results = new EnumMap<>(WinType.class);

    public WinningResultReader() {
        Arrays.stream(WinType.values())
                .forEach(it -> results.put(it, ZERO));
    }

    public Map<WinType, Integer> getWinningResult(Lottos lottos, Lotto winLotto, LottoNumber bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = lotto.matchNumberCnt(winLotto);
            boolean matchBonus = lotto.haNumber(bonusNumber);
            int existsWinCount = getWinCount(matchCount, matchBonus);
            results.put(WinType.valueOf(matchCount, matchBonus), existsWinCount + 1);
        }
        return results;
    }

    private int getWinCount(int matchCnt, boolean matchBonus) {
        Integer winCount = results.get(WinType.valueOf(matchCnt, matchBonus));
        if (winCount == null) {
            return ZERO;
        }
        return winCount;
    }
}
