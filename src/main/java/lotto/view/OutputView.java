package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPlace;
import lotto.domain.LottoWinners;

public class OutputView {

  private OutputView() {
  }

  public static void printLottoList(List<Lotto> lottoList) {
    lottoList.forEach(System.out::println);
  }

  public static void printWinner(LottoWinners winners) {

    Arrays.stream(LottoPlace.values())
        .forEach(lottoPlace -> System.out.printf("%d개 일치 (%d원)- %d\n", lottoPlace.getCount()
            , lottoPlace.getPrize(), winners.getLottoPlaceCount(lottoPlace.getCount())));

  }

  public static void printYield(double yield) {
    System.out.printf("총 수익률은 %.2f입니다.", yield);
  }
}
