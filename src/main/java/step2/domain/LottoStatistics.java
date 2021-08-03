package step2.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private static final Integer MINIMAL_SUCCESS_NUMBER = 3;
    private static final long LOTTO_PRICE = 1000L;

    private final Map<Integer, Integer> resultOfLottos = new HashMap<>();
    private final LottoNumber winOfLottoNumber;

    private BigDecimal profit;

    public LottoStatistics(LottoNumber winOfLottoNumber, List<Lotto> lottos) {
        this.winOfLottoNumber = winOfLottoNumber;
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
        final int[] sum = {0};

        resultOfLottos.forEach((key, value) -> {
            if (key == 3) {
                sum[0] += value * 5000;
            }

            if (key == 4) {
                sum[0] += value * 50000;
            }

            if (key == 5) {
                sum[0] += value * 1500000;
            }

            if (key == 6) {
                sum[0] += value * 2000000000;
            }
        });

        profit = BigDecimal.valueOf(sum[0] / (lottoCount * LOTTO_PRICE) * 100);
    }

    private void calculateLottoResult(int count) {
        if (count >= MINIMAL_SUCCESS_NUMBER) {
            resultOfLottos.put(count, resultOfLottos.getOrDefault(count, 0) + 1);
        }
    }

    public Map<Integer, Integer> resultOfLottos() {
        return resultOfLottos;
    }

    public BigDecimal getProfit() {
        return profit;
    }
}
