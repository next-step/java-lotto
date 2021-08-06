package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.service.LottoGameApplication;

public class LotteriesDrawingView {

  public static void drawLotteriesView(final LottoGameApplication gameApplication) {
    gameApplication.getLotteriesInfo()
        .getLottos()
        .stream()
        .map(LotteriesDrawingView::getEachLottoNumbers)
        .forEach(System.out::println);
    System.out.print("\n");
  }

  private static List<Integer> getEachLottoNumbers(final Lotto lotty) {
    return lotty.getLotto()
        .stream()
        .map(LottoNumber::getNumber)
        .collect(Collectors.toList());
  }
}
