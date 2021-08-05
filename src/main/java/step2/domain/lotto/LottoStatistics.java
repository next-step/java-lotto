package step2.domain.lotto;

import step2.domain.ResultOfLottos;
import java.util.List;

public class LottoStatistics {

    private static final Integer MINIMAL_SUCCESS_NUMBER = 3;

    private final ResultOfLottos resultOfLottos;
    private final LottoNumber winOfLottoNumber;

    private final Profit profit;

    public LottoStatistics(LottoNumber winOfLottoNumber, List<Lotto> lottos, ResultOfLottos resultOfLottos) {
        this.winOfLottoNumber = winOfLottoNumber;
        this.resultOfLottos = resultOfLottos;

        lottoOfStatistics(lottos);
        this.profit = calculateLottoProfit(lottos.size());
    }

    private void lottoOfStatistics(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.numbers().getNumbers();
            calculateLottoResult(winOfLottoNumber.correctCount(numbers));
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
