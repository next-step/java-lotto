package lotto.util;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public class LottoResultProvider {

    public static LottoResult getResult(List<Lotto>lottos, List<Integer> winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        lottos.forEach(lotto -> lottoResult.addWinningCount(lotto.getWinningCount(winningNumbers)));
        return lottoResult;
    }
}
