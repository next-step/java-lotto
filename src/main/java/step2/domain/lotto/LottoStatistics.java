package step2.domain.lotto;

import step2.domain.ResultOfLottos;
import java.util.List;

public class LottoStatistics {

    private static final Integer MINIMAL_SUCCESS_NUMBER = 3;

    private final ResultOfLottos resultOfLottos;
    private final Lotto winOfLottoNumber;

    private final Profit profit;

    public LottoStatistics(Lotto winOfLottoNumber, List<Lotto> lottos, ResultOfLottos resultOfLottos) {
        this.winOfLottoNumber = winOfLottoNumber;
        this.resultOfLottos = resultOfLottos;

        lottoOfStatistics(lottos);
        this.profit = calculateLottoProfit(lottos.size());
    }

    private void lottoOfStatistics(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            calculateLottoResult(winOfLottoNumber.correctCount(lotto.numbers()));
        }
    }

    private Profit calculateLottoProfit(int lottoCount) {
        return Profit.calcLottoProfit(resultOfLottos.sumMoney(), lottoCount);
    }

    private void calculateLottoResult(int count) {
        if (count >= MINIMAL_SUCCESS_NUMBER) {
            resultOfLottos.put(LottoRank.find(count));
        }
    }

    public ResultOfLottos resultOfLottos() {
        return resultOfLottos;
    }

    public Profit getProfit() {
        return profit;
    }
}
