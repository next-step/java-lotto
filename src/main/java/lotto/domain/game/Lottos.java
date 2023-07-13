package lotto.domain.game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.statistics.LottoMatch;
import lotto.domain.statistics.LottoMatchKey;

public final class Lottos {

    private final List<Lotto> lottos;
    private final Map<LottoMatch, Integer> resultMap = init();

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoMatch, Integer> getResult(final WinningNumber winningNumber) {
        for (Lotto lotto : lottos) {
            filter(lotto, winningNumber);
        }
        return resultMap;
    }

    private void filter(final Lotto lotto, final WinningNumber winningNumber) {
        int matchCount = lotto.countMatch(winningNumber.getWinningLotto());
        if (matchCount >= 3) {
            record(matchCount, lotto, winningNumber);
        }
    }

    private void record(final int matchCount, final Lotto lotto, final WinningNumber winningNumber) {
        if (matchCount == 5) {
            recordFiveMatch(matchCount, lotto, winningNumber);
            return;
        }
        recordEach(matchCount, false);
    }

    private void recordFiveMatch(final int matchCount, final Lotto lotto, final WinningNumber winningNumber) {
        if (lotto.hasLottoNumber(winningNumber.getBonusBall())) {
            recordEach(matchCount, true);
            return;
        }
        recordEach(matchCount, false);
    }

    private void recordEach(final int matchCount, final boolean isBonus) {
        LottoMatchKey lottoMatchKey = new LottoMatchKey(isBonus, matchCount);
        resultMap.put(LottoMatch.find(lottoMatchKey),
            resultMap.getOrDefault(LottoMatch.find(lottoMatchKey), 0) + 1
        );
    }

    private Map<LottoMatch, Integer> init() {
        Map<LottoMatch, Integer> resultMap = new HashMap<>();
        Arrays.stream(LottoMatch.values())
            .forEach(lottoMatch -> resultMap.put(lottoMatch, 0));
        return resultMap;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
