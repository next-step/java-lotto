package lotto.view;

import lotto.domain.LottoNo;
import lotto.domain.LottoProfit;
import lotto.domain.LottoTicket;
import lotto.domain.type.RewardPrice;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {

  public ResultView() {
  }

  public void printLottoTicketCounts(int manualTicketCount, int autoTicketCount) {
    System.out.println("\n수동으로 " + manualTicketCount + "장, 자동으로 " + autoTicketCount + "개를 구매했습니다.");
  }

  public void printLottoTickets(Set<LottoTicket> lottoTickets) {
    StringBuilder sb = new StringBuilder();
    lottoTickets.forEach(lottoTicket -> sb.append(sortByAsc(lottoTicket)).append('\n'));
    System.out.print(sb.append('\n'));
  }

  public void printLottoProfitRate(LottoProfit lottoProfit) {
    StringBuilder sb = new StringBuilder('\n');
    sb.append('\n').append("당첨 통계").append('\n').append("---------").append('\n');

    lottoProfit.getProfitMap().forEach((key, value) -> {
      sb.append(printMatchingCountResult(key));
      sb.append(printRewardResult(key, value));
    });

    sb.append("총 수익률은 ").append(lottoProfit.calculateProfitRate()).append("입니다.");
    System.out.println(sb);
  }

  private static String sortByAsc(LottoTicket lottoTicket) {
    List<Integer> sortedList = lottoTicket.getLottoNumbers()
        .stream()
        .map(LottoNo::getNo)
        .sorted()
        .collect(Collectors.toList());
    return sortedList.toString();
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
