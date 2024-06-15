package lotto.service;

import lotto.dto.LottoResult;
import lotto.entity.Lotto;
import lotto.entity.WinningLotto;
import lotto.enums.LottoRank;

import java.util.HashMap;
import java.util.List;

public class LottoResultChecker {
    public LottoResult checkResult(List<Lotto> clientLottos, WinningLotto winningLotto) {
        var result = new HashMap<LottoRank, Integer>();
        for (var lotto : clientLottos) {
            var matchCount = winningLotto.getMatchCount(lotto);
            var matchBonusNumber = winningLotto.containsBonusNumber(lotto);

            var rank = LottoRank.of(matchCount, matchBonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return new LottoResult(result);
    }
}
