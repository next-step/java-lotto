package lotto.apllication;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class LottoApplication {

  public static void main(String[] args) {
    LottoController controller = new LottoController(new LottoService());
    controller.run();
  }
}
