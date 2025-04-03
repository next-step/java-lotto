package view;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.LottoRank;
import lotto.User;

public class PrintResult {

  public static String printUserLottoTickets(User user) {
    StringBuilder result = new StringBuilder();
    // 로또 번호 출력
    for (int i = 0; i < user.getLottoTickets().size(); i++) {
      result.append(user.getLottoTickets().get(i).toString())
          .append("\n");
    }

    return result.toString();
  }

  public static String printUserProfit(User user) {
    // 로또 당첨 등수별 통계 계산
    List<LottoRank> ranks = user.evaluateLottoTickets();
    Map<LottoRank, Integer> rankCount = new EnumMap<>(LottoRank.class);

    // 모든 LottoRank 초기화
    for (LottoRank rank : LottoRank.values()) {
      if (rank != LottoRank.MISS) { // MISS는 출력하지 않으므로 제외
        rankCount.put(rank, 0);
      }
    }

    // 당첨 결과 계산
    for (LottoRank rank : ranks) {
      if (rankCount.containsKey(rank)) {
        rankCount.put(rank, rankCount.get(rank) + 1);
      }
    }

    // 결과 문자열 생성
    StringBuilder result = new StringBuilder();
    result.append("당첨 통계\n")
        .append("---------\n");

    LottoRank[] ranksArray = LottoRank.values();
    for (int i = ranksArray.length - 1; i >= 0; i--) {
      LottoRank rank = ranksArray[i];
      if (rank != LottoRank.MISS) {
        result.append(rank.getMatchedCount())
            .append("개 일치 (")
            .append(rank.getWinningAmount())
            .append("원)- ")
            .append(rankCount.get(rank))
            .append("개\n");
      }
    }

    // 총 수익률 계산 및 출력
    double profitRate = user.calculateProfitRate();
    result.append("총 수익률은 ")
        .append(String.format("%.2f", profitRate))
        .append("입니다.");

    return result.toString();
  }
}
