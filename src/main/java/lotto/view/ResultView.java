package lotto.view;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class ResultView {

  public static void print(LottoTickets lottoTickets) {
    for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
      out.println(lottoTicket);
    }
  }

  public static void print(LottoStatistics resultStatistics) {
    out.println("당첨 통계");
    out.println("---------");
    Arrays.stream(LottoRank.values())
        .sorted(Comparator.comparing(LottoRank::getMatchCount))
        .filter(LottoRank::isRewarded)
        .forEach(lottoRank -> out.println(
            lottoRank + "- " + resultStatistics.getCountByLottoRank(lottoRank) + "개"));
    out.print("총 수익률은 " + resultStatistics.getRateOfReturn() + "입니다.");
  }
}
