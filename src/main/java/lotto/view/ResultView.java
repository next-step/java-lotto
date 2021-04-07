package lotto.view;

import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.place.LottoPlaces;

import java.text.DecimalFormat;

public class ResultView {

  public static void print(LottoTicket boughtLottoTicket, LottoStore store) {
    System.out.println("당첨 통계");
    System.out.println("---------");

    LottoPlaces places = store.getLottoPlaces();
    printPlaces(places);

    long total = places.totalWinMoney();
    System.out.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", convertMoneyFormatting(total / boughtLottoTicket.totalMoneySpent()));
  }

  private static void printPlaces(LottoPlaces places) {
    places.getLottoPlaces()
            .forEach(lottoPlace -> System.out.format("%d개 일치 (%s원)- %s개\n"
                    , lottoPlace.getMatched()
                    , convertMoneyFormatting(lottoPlace.getWinMoney())
                    , convertMoneyFormatting(lottoPlace.getTotalMoney() / lottoPlace.getWinMoney())));
  }

  private static String convertMoneyFormatting(long l) {
    DecimalFormat decimalFormat = new DecimalFormat("###,###");
    return decimalFormat.format(l);
  }
}
