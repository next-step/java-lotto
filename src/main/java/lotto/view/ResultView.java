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
    out.println("3개 일치 (5000원)- " + resultStatistics.getCountByLottoRank(LottoRank.FOURTH) + "개");
    out.println("4개 일치 (50000원)- " + resultStatistics.getCountByLottoRank(LottoRank.THIRD) + "개");
    out.println("5개 일치 (5000원)- " + resultStatistics.getCountByLottoRank(LottoRank.SECOND) + "개");
    out.println(
        "6개 일치 (2000000000원)- " + resultStatistics.getCountByLottoRank(LottoRank.TOP) + "개");
    out.print("총수익률은 " + resultStatistics.getRateOfReturn() + "입니다.");
  }
}
