package lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputView {

    private final Calculator calculator;
    private final PrizeService prizeService;

    public OutputView(Calculator calculator, PrizeService prizeService) {
        this.calculator = calculator;
        this.prizeService = prizeService;
    }

    public void printPurchasedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println("[" + lotto.printNumber() + "]");
        }
    }

    public void statisticLotto(List<Lotto> lottos, List<Integer> winningNumber) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<Integer, Integer> rankMap = prizeService.confirmRank(lottos, winningNumber);
        printRank(rankMap);
        printYield(rankMap, lottos.size());
    }

    private void printYield(Map<Integer, Integer> rankMap, int purchaseCount) {
        BigDecimal purchaseAmount = calculator.calculatePurchaseAmount(purchaseCount);
        BigDecimal prizeMoney = calculator.calculatePrizeMoney(rankMap);
        System.out.println(
                "총 수익률은 " + String.format("%.3f", calculator.calculateYield(purchaseAmount, prizeMoney)) +
                "입니다.");
    }

    private void printRank(Map<Integer, Integer> rankMap) {
        Arrays.stream(Prize.values()).sorted(Comparator.comparing(Prize::getWinningCount)).forEach(p -> {
            System.out.println(p.getWinningCount() + "개 일치 (" + p.getPrizeMoney() + "원) - " +
                               rankMap.get(p.getWinningCount()) + "개");
        });
    }
}
