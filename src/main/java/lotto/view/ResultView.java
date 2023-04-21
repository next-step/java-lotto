package lotto.view;

import lotto.domain.*;

import java.util.stream.Collectors;

public class ResultView {

  private ResultView() {
  }

  public static void showLottoTickets(LottoTickets lottoTickets) {
    for (LottoTicket lottoTicket : lottoTickets.unmodifiedLottoTickets()) {
      printLottoTicket(lottoTicket);
    }
    System.out.println();
  }

  public static void showLottoResult(LottoResult lottoResult) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");

    lottoResult.numbersPerRank().forEach((rankNumber, matchedNumber) -> {
      System.out.println(rankNumber + "개 일치 (" + LottoRank.prizeMoney(LottoRank.valueOfMatchedCount(rankNumber)) + ")- " + matchedNumber + "개");
    });

    System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", lottoResult.lottoRateOfReturn(), isProfitable(lottoResult));
  }

  private static String isProfitable(LottoResult lottoResult) {
    if (lottoResult.lottoRateOfReturn() >= 1) {
      return "이득";
    }
    return "손해";
  }

  private static void printLottoTicket(LottoTicket lottoTicket) {
    String lottoTicketNumbers = lottoTicket.lottoTicketNumbers().stream()
            .map(LottoNumber::number)
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
    System.out.println("[" + lottoTicketNumbers + "]");
  }
}
