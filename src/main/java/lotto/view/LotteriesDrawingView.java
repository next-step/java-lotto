package lotto.view;

import lotto.domain.Lotteries;

public class LotteriesDrawingView {

  public static void drawLotteriesView(final Lotteries lotteries) {

    for (String message : Lotteries.toStringLottoInfo(lotteries)) {
      System.out.println(message);
    }
    System.out.print("\n");
  }

}