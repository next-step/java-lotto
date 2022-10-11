package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoStatistic {
    private int winMoneyTotal = 0;
    private double revenue;
    private Map<LottoResult, Integer> lottoResultCounter = new EnumMap<>(LottoResult.class);

    public void analyze(List<Lotto> lottos, Lotto beforeWinLotto, PurchaseInfo purchaseInfo) {
        List<LottoResult> lottoResults = toLottoResult(lottos, beforeWinLotto);

        plusLottoResultCount(lottoResults);
        sumWinMoney(lottoResults);
        calculateRevenue(purchaseInfo);
    }

    private List<LottoResult> toLottoResult(List<Lotto> lottos, Lotto beforeWinLotto) {
        return lottos.stream()
                .map(lotto -> lotto.getResult(beforeWinLotto))
                .collect(Collectors.toList());
    }

    private void plusLottoResultCount(List<LottoResult> lottoResults) {
        lottoResults.stream()
                .filter(Objects::nonNull)
                .forEach(lottoResult -> lottoResultCounter.merge(lottoResult, 1, (result, count) -> result + count));
    }

    private void sumWinMoney(List<LottoResult> lottoResult) {
        winMoneyTotal = lottoResult.stream()
                .filter(Objects::nonNull)
                .map(LottoResult::getMoney)
                .collect(reducing(0, e -> e, Integer::sum));
    }

    private void calculateRevenue(PurchaseInfo purchaseInfo) {
        revenue = Double.valueOf(winMoneyTotal) / Double.valueOf(purchaseInfo.getPurchaseAmount());
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
