package lotto.view;

import lotto.constants.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoPrint {

    private final String ENTER = "\n";
    private StringBuilder stringBuilder = new StringBuilder();

    public void lottoResult(List<Integer> matchedLottoList, int purchasedAmount) {

        stringBuilder
                .append("당첨통계")
                .append(ENTER)
                .append("----------")
                .append(ENTER);

        Map<String, Integer> rankCounts  = initializeRankCounts();
        rankCounts = countMatch(rankCounts, matchedLottoList);
        generateResult(rankCounts);
        calculateProfitRate(rankCounts, purchasedAmount);
    }

    private Map<String, Integer> initializeRankCounts() {
        Map<String, Integer> rankCounts = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank.getRank(), 0);
        }
        return rankCounts;
    }

    private Map<String, Integer> countMatch(Map<String, Integer> rankCounts, List<Integer> matchedLottoList) {

        for (Integer count : matchedLottoList) {
            LottoRank lottoRank = LottoRank.findByCount(String.valueOf(count));
            rankCounts.put(lottoRank.getRank(), rankCounts.get(lottoRank.getRank()) + 1);
        }

        return rankCounts;

    }

    private void generateResult(Map<String, Integer> rankCounts) {

        for (LottoRank rank : LottoRank.values()) {
            stringBuilder.append(rankCounts.get(rank.getRank()))
                    .append("개 일치 (")
                    .append(rank.getAmount())
                    .append("원) - ")
                    .append(rank.getRank())
                    .append(ENTER);
        }

        // 순이익/투자 비용 x 100

        System.out.println(stringBuilder);
    }

    private void calculateProfitRate(Map<String, Integer> rankCounts, int purchasedAmount) {

        long totalEarnings = 0;

        // 각 랭크에 대해 당첨 금액 계산
        for (LottoRank rank : LottoRank.values()) {
            totalEarnings += rank.getAmount() * rankCounts.get(rank.getRank());
        }

        double profitRate = ((double) totalEarnings - purchasedAmount) / purchasedAmount * 100;
        stringBuilder.append("총 수익률은: ")
                .append(String.format("%.2f", profitRate))
                .append("입니다.");

        System.out.println(stringBuilder);

    }
}
