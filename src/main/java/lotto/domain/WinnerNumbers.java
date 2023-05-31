package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinnerNumbers {

    private final Lotto winnerNumbers;
    private final LottoNumber bonusNumber;

    public WinnerNumbers(String winnerNumbers, int bonusNumber) {
        this.winnerNumbers = new Lotto(winnerNumbers);
        this.bonusNumber = LottoNumber.valueOf(bonusNumber);
        if (this.winnerNumbers.hasNumber(this.bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨번호에 없는 숫자여야 합니다.");
        }
    }

    public LottoResults matchLottos(Lottos lottos) {
        Map<Rank, Integer> winningStats = new HashMap<>();
        initializeWinningStats(winningStats);
        markResults(winningStats, lottos);
        return new LottoResults(winningStats);
    }

    private void initializeWinningStats(Map<Rank, Integer> winningStats) {
        Arrays.stream(Rank.values())
                .forEach(rank -> winningStats.put(rank, 0));
    }

    private void markResults(Map<Rank, Integer> winningStats, Lottos lottos) {
        lottos.allLottos().forEach(lotto -> this.markResult(winningStats, lotto));
    }

    private void markResult(Map<Rank, Integer> winningStats, Lotto lotto) {
        int matchCount = this.matchCount(lotto);
        boolean matchBonus = this.matchBonus(lotto);
        Rank rank = Rank.find(matchCount, matchBonus);
        if (rank != null) {
            winningStats.compute(rank, (k, v) -> v + 1);
        }
    }

    private int matchCount(Lotto lotto) {
        return lotto.matchCount(this.winnerNumbers);
    }

    private boolean matchBonus(Lotto lotto) {
        return lotto.hasNumber(this.bonusNumber);
    }
}
