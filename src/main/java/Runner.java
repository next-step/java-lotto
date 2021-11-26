import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Runner {

    public static void main(String[] args) {
        new LottoController(new LottoService()).start();
    }
}
