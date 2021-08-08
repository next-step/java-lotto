package step3.domain.lotto;

import java.util.List;

public class LottoStatistics {

    public static ResultOfLottos calcLottoOfStatistics(WinOfLotto winOfLottoNumber, List<Lotto> lottos) {
        ResultOfLottos resultOfLottos = new ResultOfLottos();

        for (Lotto lotto : lottos) {
            int count = winOfLottoNumber.correctCount(lotto.numbers());
            boolean hasBonusNumber = winOfLottoNumber.hasBonusNumber(lotto);
            resultOfLottos.put(LottoRank.find(count, hasBonusNumber));
        }

        return resultOfLottos;
    }

    public static Profit calculateLottoProfit(ResultOfLottos resultOfLottos, int lottoCount) {
        return Profit.calcLottoProfit(resultOfLottos.sumMoney(), lottoCount);
    }


}
