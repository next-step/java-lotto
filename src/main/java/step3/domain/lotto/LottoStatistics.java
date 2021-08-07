package step3.domain.lotto;

import java.util.List;

public class LottoStatistics {

    private static final Integer MINIMAL_SUCCESS_NUMBER = 3;

    public static ResultOfLottos calcLottoOfStatistics(WinOfLotto winOfLottoNumber, List<Lotto> lottos) {
        ResultOfLottos resultOfLottos = new ResultOfLottos();

        for (Lotto lotto : lottos) {
            int count = winOfLottoNumber.correctCount(lotto.numbers());
            boolean hasBonusNumber = winOfLottoNumber.hasBonusNumber(lotto);

            if (count >= MINIMAL_SUCCESS_NUMBER) {
                resultOfLottos.put(LottoRank.find(count, hasBonusNumber));
            }
        }

        return resultOfLottos;
    }

    public static Profit calculateLottoProfit(ResultOfLottos resultOfLottos, int lottoCount) {
        return Profit.calcLottoProfit(resultOfLottos.sumMoney(), lottoCount);
    }


}
