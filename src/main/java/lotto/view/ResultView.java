package lotto.view;

import lotto.domain.LottoProfit;
import lotto.domain.LottoTicket;
import lotto.domain.type.RewardPrice;

import java.util.List;

public class ResultView {

  public ResultView() {
  }

  public void printLottoTicketCounts(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public void printLottoTickets(List<LottoTicket> lottoTickets) {
    StringBuilder sb = new StringBuilder();
    lottoTickets.forEach(lottoTicket -> sb.append(lottoTicket.toString()).append('\n'));
    System.out.println(sb.append('\n'));
  }

  public void printLottoProfitRate(LottoProfit lottoProfit) {
    StringBuilder sb = new StringBuilder('\n');
    sb.append("당첨 통계").append('\n').append("---------").append('\n');

    lottoProfit.getProfitMap().forEach((key, value) -> {
      printRewardResult(sb, key, value);
    });

    sb.append("총 수익률은 ").append(lottoProfit.calculateProfitRate()).append("입니다.");
    System.out.println(sb);
  }

  private static void printRewardResult(StringBuilder sb, RewardPrice key, Integer value) {
    sb.append(key.matchCount()).append("개 일치")
        .append('(').append(key.rewardAmount()).append("원)")
        .append(" - ").append(value).append('개').append('\n');
  }
}
