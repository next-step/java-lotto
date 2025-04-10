package app;

import controller.LottoController;
import service.LottoService;
import util.LottoNumberGenerator;

public class LottoGameApplication {
    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoService lottoService = new LottoService(lottoNumberGenerator);
        LottoController lottoController = new LottoController(lottoService);
        lottoController.run();
    }
}
