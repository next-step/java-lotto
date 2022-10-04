package lotto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int RANK_4TH = 3;
    private static final int RANK_3TH = 4;
    private static final int RANK_2TH = 5;
    private static final int RANK_1TH = 6;

    private static final BigDecimal RANK_4TH_PRICE = BigDecimal.valueOf(5000);
    private static final BigDecimal RANK_3TH_PRICE = BigDecimal.valueOf(50000);
    private static final BigDecimal RANK_2TH_PRICE = BigDecimal.valueOf(1500000);
    private static final BigDecimal RANK_1TH_PRICE = BigDecimal.valueOf(2000000000);

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
        System.out.println("총 수익률은 " + String.format("%.3f",calculator.calculateYield(purchaseAmount, prizeMoney)) + "입니다.");
    }

    private BigDecimal getPrizeMoney(Map<Integer, Integer> rankMap) {
        BigDecimal prizeMoney = BigDecimal.ZERO;

        prizeMoney = prizeMoney.add(BigDecimal.valueOf(rankMap.get(RANK_4TH)).multiply(RANK_4TH_PRICE));
        prizeMoney = prizeMoney.add(BigDecimal.valueOf(rankMap.get(RANK_3TH)).multiply(RANK_3TH_PRICE));
        prizeMoney = prizeMoney.add(BigDecimal.valueOf(rankMap.get(RANK_2TH)).multiply(RANK_2TH_PRICE));
        prizeMoney = prizeMoney.add(BigDecimal.valueOf(rankMap.get(RANK_1TH)).multiply(RANK_1TH_PRICE));

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
        System.out.println("3개 일치 (5000원)- " + rankMap.get(RANK_4TH) + "개");
        System.out.println("4개 일치 (50000원)- " + rankMap.get(RANK_3TH) + "개");
        System.out.println("5개 일치 (1500000원)- " + rankMap.get(RANK_2TH) + "개");
        System.out.println("6개 일치 (2000000000원)- " + rankMap.get(RANK_1TH) + "개");
    }

    private Map<Integer, Integer> initRankMap() {
        Map<Integer, Integer> rankMap = new HashMap<>();
        rankMap.put(RANK_4TH, 0);
        rankMap.put(RANK_3TH, 0);
        rankMap.put(RANK_2TH, 0);
        rankMap.put(RANK_1TH, 0);
        return rankMap;
    }

    private void addRankMap(Map<Integer, Integer> rankMap, int matchingCount) {
        if (matchingCount < RANK_4TH) {
            return;
        }
        rankMap.put(matchingCount, rankMap.get(matchingCount) + 1);
    }
}
