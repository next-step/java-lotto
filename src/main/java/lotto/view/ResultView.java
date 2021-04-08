package lotto.view;

import lotto.domain.place.LottoPlaces;

import static calculator.util.StringUtil.convertMoneyFormatting;

public class ResultView {
  private static final String ALARM_WINNING_STATISTICS = "당첨 통계";
  private static final String INCISION_LINE = "---------";
  private static final String RETURN_ON_INVESTMENT_FORMAT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
  private static final String LOTTO_PLACES_RESULT_FORMAT = "%d개 일치 (%s원)- %s개\n";

  public static void print(LottoPlaces places, long returnOnInvestment) {
    System.out.println(ALARM_WINNING_STATISTICS);
    System.out.println(INCISION_LINE);

    printPlaces(places);

    System.out.format(RETURN_ON_INVESTMENT_FORMAT, convertMoneyFormatting(returnOnInvestment));
  }

  public static void printPlaces(LottoPlaces places) {
    places.getLottoPlaces()
            .forEach(lottoPlace -> System.out.format(LOTTO_PLACES_RESULT_FORMAT, lottoPlace.getMatched()
                    , convertMoneyFormatting(lottoPlace.getWinMoney())
                    , convertMoneyFormatting(lottoPlace.getReturnOnInvestment()))
            );
  }

}
