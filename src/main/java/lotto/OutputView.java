package lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final BigDecimal PRICE_PER_LOTTO = BigDecimal.valueOf(1000);

    private final Calculator calculator;

    public OutputView(Calculator calculator) {this.calculator = calculator;}

    public void printPurchasedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println("[" + lotto.printNumber() + "]");
        }
    }

    public void statisticLotto(List<Lotto> lottos, List<Integer> winningNumber) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<Integer, Integer> rankMap = findRank(lottos, winningNumber);
        printRank(rankMap);
        printYield(rankMap, lottos.size());
    }

    private void printYield(Map<Integer, Integer> rankMap, int size) {
        BigDecimal purchaseAmount = PRICE_PER_LOTTO.multiply(BigDecimal.valueOf(size));
        BigDecimal prizeMoney = getPrizeMoney(rankMap);
        System.out.println(
                "총 수익률은 " + String.format("%.3f", calculator.calculateYield(purchaseAmount, prizeMoney)) +
                "입니다.");
    }

    private BigDecimal getPrizeMoney(Map<Integer, Integer> rankMap) {
        BigDecimal prizeMoney = BigDecimal.ZERO;

        for (Prize value : Prize.values()) {
            prizeMoney = prizeMoney.add(
                    BigDecimal.valueOf(rankMap.get(value.getWinningCount())).multiply(value.getPrizeMoney()));
        }

        return prizeMoney;
    }

    private Map<Integer, Integer> findRank(List<Lotto> lottos, List<Integer> winningNumber) {
        Map<Integer, Integer> rankMap = initRankMap();

        for (Lotto lotto : lottos) {
            int matchingCount = lotto.findMatchingCount(winningNumber);
            addRankMap(rankMap, matchingCount);
        }
        return rankMap;
    }

    private void printRank(Map<Integer, Integer> rankMap) {
        Arrays.stream(Prize.values()).sorted(Comparator.comparing(Prize::getWinningCount)).forEach(p -> {
            System.out.println(p.getWinningCount() + "개 일치 (" + p.getWinningCount() + "원) - " +
                               rankMap.get(p.getWinningCount()) + "개");
        });
    }

    private Map<Integer, Integer> initRankMap() {
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (Prize value : Prize.values()) {
            rankMap.put(value.getWinningCount(), 0);
        }
        return rankMap;
    }

    private void addRankMap(Map<Integer, Integer> rankMap, int matchingCount) {
        if (matchingCount < Prize.RANK_4TH.getWinningCount()) {
            return;
        }
        rankMap.put(matchingCount, rankMap.get(matchingCount) + 1);
    }
}
