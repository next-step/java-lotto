package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LotteriesDrawingView {

  public static void drawLotteriesView(final Lotteries lotteries) {
    lotteries
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