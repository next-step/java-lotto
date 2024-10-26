package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class LottoGameMain {

    public static void main(String[] args) {
        LottoService service = new LottoService();
        LottoController controller = new LottoController(service);
        controller.play();
    }
}
