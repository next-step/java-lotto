package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.service.LotteryDraw;

public class LotteriesDrawingView {

  public static void drawLotteriesView(final LotteryDraw lotteryDraw) {
    for (Lotto lotto : lotteryDraw.getLotteriesInfo().getLottos()) {
      List<Integer> eachLottoNumbers = getEachLottoNumbers(lotto);
      System.out.println(eachLottoNumbers);
    }
    System.out.print("\n");
  }

  private static List<Integer> getEachLottoNumbers(final Lotto lotty) {
    return lotty.getLotto()
        .stream()
        .map(LottoNumber::getNumber)
        .collect(Collectors.toList());
  }
}
