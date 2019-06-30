package lotto.util;

import lotto.model.Lottery;
import lotto.model.LottoResult;

import java.util.List;

public class LottoResultProvider {

    public static LottoResult getResult(List<Lottery> lotteries, List<Integer> winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        lotteries.forEach(lotto -> lottoResult.addWinningCount(lotto.getWinningCount(winningNumbers)));
        return lottoResult;
    }
}
