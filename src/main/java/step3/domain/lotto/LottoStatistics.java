package step3.domain.lotto;

import java.util.List;

public class LottoStatistics {

    public LottoMatch calcLottoOfStatistics(WinOfLotto winOfLottoNumber, List<Lotto> lottos) {
        LottoMatch lottoMatch = new LottoMatch();

        for (Lotto lotto : lottos) {
            int count = winOfLottoNumber.correctCount(lotto.numbers());
            boolean hasBonusNumber = winOfLottoNumber.hasBonusNumber(lotto);
            lottoMatch.put(LottoRank.find(count, hasBonusNumber));
        }

        return lottoMatch;
    }

    public static Profit calculateLottoProfit(LottoMatch lottoMatch, int lottoCount) {
        return Profit.calcLottoProfit(lottoMatch.sumMoney(), lottoCount);
    }


}
