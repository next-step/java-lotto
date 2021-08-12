package lotto.view;

import lotto.domain.Lotteries;

public class LotteriesDrawingView {

  public static void drawLotteriesView(final Lotteries lotteries) {
    Lotteries.toStringLottoInfo(lotteries);
    System.out.print("\n");
  }

}