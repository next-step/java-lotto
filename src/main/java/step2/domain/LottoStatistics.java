package step2.domain;

import step2.util.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoStatistics {

    private static final Integer MINIMAL_SUCCESS_NUMBER = 3;
    private static final int LOTTO_PRICE = 1000;

    private final Map<Integer, Integer> resultOfLottos = new HashMap<>();
    private final LottoNumber winOfLottoNumber;

    private double profit;

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
        AtomicInteger sum = new AtomicInteger();

        resultOfLottos.forEach((rank, count) -> {
            LottoRank lottoRank = LottoRank.find(rank);
            sum.addAndGet(count * lottoRank.getMoney());
        });

        profit = Utils.lottoPercent(sum.get(), lottoCount * LOTTO_PRICE);
    }

    private void calculateLottoResult(int count) {
        if (count >= MINIMAL_SUCCESS_NUMBER) {
            resultOfLottos.put(count, resultOfLottos.getOrDefault(count, 0) + 1);
        }
    }

    public Map<Integer, Integer> resultOfLottos() {
        return resultOfLottos;
    }

    public Double getProfit() {
        return profit;
    }
}
