package lotto.dto;

import java.util.Map;

public class UserLottoResult {
    private static double totalPrice = 0.f;

    public static String userLottoResult() {
        StringBuilder sb = new StringBuilder();
        Map<LottoResult, Integer> matchTable = LottoMatchResult.getMatchTable();

        for (LottoResult lottoType : matchTable.keySet()) {
            int userMatchCount = matchTable.get(lottoType);
            totalPrice += (lottoType.money * userMatchCount);
            sb.append(String.format("%s개 일치 (%s원)- %s개\n", lottoType.matchCount, lottoType.money, userMatchCount));
        }
        return sb.toString();
    }

    public static String userLottRateOfResult() {
        return String.format("총 수익률은 %.2f입니다.", (int) (totalPrice / Money.getMoney() * 100) / 100.0);
    }
}
