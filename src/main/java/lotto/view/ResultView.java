package lotto.view;

import static java.lang.System.out;

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
    out.println(LottoRank.FOURTH + "- " + resultStatistics.getCountByLottoRank(LottoRank.FOURTH) + "개");
    out.println(LottoRank.THIRD + "- " + resultStatistics.getCountByLottoRank(LottoRank.THIRD) + "개");
    out.println(LottoRank.SECOND + "- " + resultStatistics.getCountByLottoRank(LottoRank.SECOND) + "개");
    out.println(LottoRank.TOP + "- " + resultStatistics.getCountByLottoRank(LottoRank.TOP) + "개");
    out.print("총 수익률은 " + resultStatistics.getRateOfReturn() + "입니다.");
  }
}
