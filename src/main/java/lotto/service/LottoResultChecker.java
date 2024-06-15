package lotto.service;

import lotto.dto.LottoResult;
import lotto.entity.Lotto;
import lotto.enums.LottoRank;

import java.util.HashMap;
import java.util.List;

public class LottoResultChecker {
    public LottoResult checkResult(List<Lotto> clientLottos, Lotto winningLotto, int bonusNumber) {
        var result = new HashMap<LottoRank, Integer>();
        for (var lotto : clientLottos) {
            var matchCount = match(lotto, winningLotto);
            var matchBonusNumber = lotto.contains(bonusNumber);

            var rank = LottoRank.of(matchCount, matchBonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return new LottoResult(result);
    }

    private int match(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
}
