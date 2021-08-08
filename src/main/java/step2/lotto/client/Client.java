package step2.lotto.client;

import step2.lotto.*;
import step2.lotto.result.LottoResult;
import step2.lotto.result.LottoResults;
import step2.lotto.result.ResultStatistic;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Client {

    private long money = 0;
    private Lottos lottos;

    public Client(long money) {
        this.money = money;
    }

    public void buyLotto(Lottos lottos) {
        validateBuyableLotto(lottos);
        this.lottos = lottos;
        this.money -= lottos.price();
    }

    public long buyableLottoCount() {
        return money / Lotto.PRICE;
    }

    private void validateBuyableLotto(Lottos lottos) {
        int lottosPrice = lottos.price();
        if (money - lottosPrice < 0)
            throw new IllegalStateException("로또 살 돈이 부족합니다");
    }

    public long remainMoney() {
        return this.money;
    }

    public ResultStatistic calculateResultStatistic(LottoNumber winningNumber) {
        int boughtLottoCount = lottos.count();
        LottoResults lottoResults = checkResultOfLotto(winningNumber);
        long sumOfPrizeMoney = lottoResults.sumOfPrizeMoney();
        double totalRevenueRate = getTotalRevenueRate(boughtLottoCount, sumOfPrizeMoney);
        return new ResultStatistic(totalRevenueRate, lottoResults);
    }

    private double getTotalRevenueRate(long boughtLottoCount, long sumOfPrizeMoney) {
        BigDecimal totalPrizeMoney = BigDecimal.valueOf(sumOfPrizeMoney);
        BigDecimal lottoBoughtAmount = BigDecimal.valueOf(boughtLottoCount * Lotto.PRICE);

        double totalRevenueRate = totalPrizeMoney.divide(lottoBoughtAmount, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return totalRevenueRate;
    }

    private LottoResults checkResultOfLotto(LottoNumber winningNumber) {
        List<LottoResult> lottoResults = lottos.stream()
                .map(lotto -> new LottoResult(winningNumber, lotto))
                .collect(Collectors.toList());

        return new LottoResults(lottoResults);
    }

}
