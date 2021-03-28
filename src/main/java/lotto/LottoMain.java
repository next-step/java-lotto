package lotto;

import java.io.IOException;
import lotto.controller.LottoController;

public class LottoMain {
  public static void main(String[] args) throws IOException {
    LottoController main = new LottoController();
    main.userInput();
    main.lottoResult();
  }
}
