package lotto.view;

import lotto.domain.LottoProfit;
import lotto.domain.LottoTicket;
import lotto.domain.type.RewardPrice;

import java.util.Set;

public class ResultView {

  public ResultView() {
  }

  public void printLottoTicketCounts(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public void printLottoTickets(Set<LottoTicket> lottoTickets) {
    StringBuilder sb = new StringBuilder();
    lottoTickets.forEach(lottoTicket -> sb.append(lottoTicket.toString()).append('\n'));
    System.out.println(sb.append('\n'));
  }

  public void printLottoProfitRate(LottoProfit lottoProfit) {
    StringBuilder sb = new StringBuilder('\n');
    sb.append("당첨 통계").append('\n').append("---------").append('\n');

    lottoProfit.getProfitMap().forEach((key, value) -> {
      sb.append(printMatchingCountResult(key));
      sb.append(printRewardResult(key, value));
    });

    sb.append("총 수익률은 ").append(lottoProfit.calculateProfitRate()).append("입니다.");
    System.out.println(sb);
  }

  private static StringBuilder printMatchingCountResult(RewardPrice key) {
    StringBuilder sb = new StringBuilder();
    if (key.isMatchBonusBall()) {
      return sb.append(key.matchCount()).append("개 일치, 보너스 볼 일치");
    }
    return sb.append(key.matchCount()).append("개 일치");
  }

  private static StringBuilder printRewardResult(RewardPrice key, Integer value) {
    StringBuilder sb = new StringBuilder();
    return sb.append('(').append(key.rewardAmount()).append("원)")
        .append(" - ").append(value).append('개').append('\n');
  }
}
