package step2.domain.lotto;

import step2.domain.ResultOfLottos;
import step2.util.CalcUtils;
import java.util.List;

public class LottoStatistics {

    private static final Integer MINIMAL_SUCCESS_NUMBER = 3;
    private static final int LOTTO_PRICE = 1000;

    private final ResultOfLottos resultOfLottos;
    private final LottoNumber winOfLottoNumber;

    private double profit;

    public LottoStatistics(LottoNumber winOfLottoNumber, List<Lotto> lottos, ResultOfLottos resultOfLottos) {
        this.winOfLottoNumber = winOfLottoNumber;
        this.resultOfLottos = resultOfLottos;
        lottoOfStatistics(lottos);
        calculateLottoProfit(lottos.size());
    }

    private void lottoOfStatistics(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.numbers().getNumbers();
            calculateLottoResult(winOfLottoNumber.correctCount(numbers));
        }
    }

    private void calculateLottoProfit(int lottoCount) {
        Integer sum = resultOfLottos.sumMoney();
        profit = CalcUtils.lottoPercent(sum, lottoCount * LOTTO_PRICE);
    }

    private void calculateLottoResult(int count) {
        if (count >= MINIMAL_SUCCESS_NUMBER) {
            resultOfLottos.put(count);
        }
    }

    public ResultOfLottos resultOfLottos() {
        return resultOfLottos;
    }

    public Double getProfit() {
        return profit;
    }
}
