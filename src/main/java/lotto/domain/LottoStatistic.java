package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.reducing;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoStatistic {

    private final Lotto beforeWinLotto;
    private final Buy buy;

    private int winMoneyTotal = 0;
    private double revenue;

    private Map<LottoResult, Integer> lottoResultCounter = new EnumMap<>(LottoResult.class);

    public LottoStatistic(Lotto beforeWinLotto, Buy buy, List<Lotto> lottos) {
        this.beforeWinLotto = beforeWinLotto;
        this.buy = buy;

        analyze(lottos);
    }

    public void analyze(List<Lotto> lottos) {
        plusLottoResultCount(lottos);
        sumWinMoney(lottos);
        calculateRevenue();
    }

    private void plusLottoResultCount(List<Lotto> lotts) {
        lotts.stream()
                .map(this::toLottoResult)
                .forEach(lottoResult -> lottoResultCounter.merge(lottoResult, 1, (result, count) -> result + count));
    }

    private void sumWinMoney(List<Lotto> lottoResult) {
        winMoneyTotal = lottoResult.stream()
                .map(this::toLottoResult)
                .map(LottoResult::getMoney)
                .collect(reducing(0, e -> e, Integer::sum));
    }
    private LottoResult toLottoResult (Lotto lotto) {
        return lotto.getResult(beforeWinLotto);
    }

    private void calculateRevenue() {
        revenue = Double.valueOf(winMoneyTotal) / Double.valueOf(buy.getPay());
    }

    public int getWinMoneyTotal() {
        return winMoneyTotal;
    }

    public Map<LottoResult, Integer> getLottoResultCounter() {
        return lottoResultCounter;
    }

    public boolean isLost() {
        return revenue < 1.0;
    }

    public double getRevenue() {
        return revenue;
    }
}
