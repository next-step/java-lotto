package lottogame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;
    Map<LottoMatch, Integer> resultMap = init();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    // TODO : Statistics 통계 객체로 뺄지
    public Map<LottoMatch, Integer> getResult(WinningNumber winningNumber) {
        for (Lotto lotto : lottos) {
            filter(lotto, winningNumber);
        }
        return resultMap;
    }

    private void filter(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = lotto.countMatch(winningNumber.getWinningLotto());
        if (matchCount >= 3) {
            record(matchCount, lotto, winningNumber);
        }
    }

    private void record(int matchCount, Lotto lotto, WinningNumber winningNumber) {
        if (matchCount == 5) {
            recordFiveMatch(lotto, winningNumber);
            return;
        }
        recordEach(matchCount);
    }

    private void recordFiveMatch(Lotto lotto, WinningNumber winningNumber) {
        if (lotto.hasLottoNumber(winningNumber.getBonusBall())) {
            recordEach(7);
        }
    }

    private void recordEach(int matchCount) {
        resultMap.put(
            LottoMatch.find(matchCount),
            resultMap.getOrDefault(LottoMatch.find(7), 0) + 1
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
