package lotto.view;

import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.place.LottoPlaces;

import java.text.DecimalFormat;

public class ResultView {
  private static final String ALARM_WINNING_STATISTICS = "당첨 통계";
  private static final String INCISION_LINE = "---------";
  private static final String RETURN_ON_INVESTMENT_FORMAT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
  private static final String LOTTO_PLACES_RESULT_FORMAT = "%d개 일치 (%s원)- %s개\n";

  public static void print(LottoTicket boughtLottoTicket, LottoStore store) {
    System.out.println(ALARM_WINNING_STATISTICS);
    System.out.println(INCISION_LINE);

    LottoPlaces places = store.getLottoPlaces();
    printPlaces(places);

    long total = places.totalWinMoney();
    System.out.format(RETURN_ON_INVESTMENT_FORMAT, convertMoneyFormatting(total / boughtLottoTicket.totalMoneySpent()));
  }

  private static void printPlaces(LottoPlaces places) {
    places.getLottoPlaces()
            .forEach(lottoPlace -> System.out.format(LOTTO_PLACES_RESULT_FORMAT, lottoPlace.getMatched()
                    , convertMoneyFormatting(lottoPlace.getWinMoney())
                    , convertMoneyFormatting(lottoPlace.getTotalMoney() / lottoPlace.getWinMoney()))
            );
  }

  private static String convertMoneyFormatting(long l) {
    DecimalFormat decimalFormat = new DecimalFormat("###,###");
    return decimalFormat.format(l);
  }
}
