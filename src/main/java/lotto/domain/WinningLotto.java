package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningLotto {
    private final Lotto winLotto;
    private final LottoNumber bonusNumber;
    private static final int ZERO = 0;
    private final Map<WinType, Integer> winResults = new EnumMap<>(WinType.class);

    public WinningLotto(Lotto winLotto, LottoNumber bonusNumber) {
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
        Arrays.stream(WinType.values())
                .forEach(it -> winResults.put(it, ZERO));
    }

    public Map<WinType, Integer> matchWinning(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = lotto.matchNumberCnt(winLotto);
            boolean matchBonus = checkBonusMatch(lotto);
            int existsWinCount = getWinCount(matchCount, matchBonus);
            winResults.put(WinType.valueOf(matchCount, matchBonus), existsWinCount + 1);
        }

        return winResults;
    }

    private boolean checkBonusMatch(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }

    private int getWinCount(int matchCnt, boolean matchBonus) {
        Integer winCount = winResults.get(WinType.valueOf(matchCnt, matchBonus));

        if (winCount == null) {
            return ZERO;
        }
        return winCount;
    }
}
