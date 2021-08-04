package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.service.LotteryDraw;

public class LottiesDrawingView {

  public LottiesDrawingView(LotteryDraw lotteryDraw) {
    lotteryDraw.getLottiesInfo().getLotties()
        .stream()
        .map(lotty -> lotty.getLotto()
            .stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList()))
        .forEach(System.out::println);
  }
}
