package lotto;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {
    new LottoService(new InputView(), new ResultView()).run();
  }
}
