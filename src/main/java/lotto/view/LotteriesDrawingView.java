package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.LotteriesDto;

public class LotteriesDrawingView {

  public static void drawLotteriesView(final LotteriesDto lotteries) {

    for (Lotto lotto : lotteries.values()) {
      System.out.println(lotto.toString());
    }
    System.out.print("\n");
  }

}