package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoStatistic {

    private final Lotto beforeWinLotto;
    private final Buy buy;

    private int winMoneyTotal = 0;
    ;

    private double revenue;

    private Map<LottoResult, Integer> lottoResultCounter = new EnumMap<>(LottoResult.class);

    public LottoStatistic(Lotto beforeWinLotto, Buy buy) {
        this.beforeWinLotto = beforeWinLotto;
        this.buy = buy;
    }

    public void add(Lotto lotto) {
        LottoResult lottoResult = lotto.getResult(beforeWinLotto);

        sumWinMoney(lottoResult);
        plusLottoResultCount(lottoResult);
    }

    private void plusLottoResultCount(LottoResult lottoResult) {
        lottoResultCounter.merge(lottoResult, 1, (result, count) -> result + count);
    }

    private void sumWinMoney(LottoResult lottoResult) {
        winMoneyTotal += lottoResult.getMoney();
    }

    public int getWinMoneyTotal() {
        return winMoneyTotal;
    }

    public Map<LottoResult, Integer> getLottoResultCounter() {
        return lottoResultCounter;
    }

    public double getRevenue() {
        if (revenue == 0) {
            revenue = Double.valueOf(winMoneyTotal) / Double.valueOf(buy.getPay());
        }

        return revenue;
    }

    public boolean isLost() {
        return revenue < 1.0;
    }
}
