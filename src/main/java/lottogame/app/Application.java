package lottogame.app;

import lottogame.console.ConsoleLottoInputer;
import lottogame.console.ConsoleLottoViewer;
import lottogame.controller.LottoController;
import lottogame.controller.spi.LottoInputer;
import lottogame.controller.spi.LottoViewer;
import lottogame.domain.LottoTicket;
import lottogame.domain.LottoTickets;
import lottogame.domain.spi.NumberGenerator;
import lottogame.randomnumber.RandomLottoNumberGenerator;

import java.util.List;

public class Application {

    private final LottoController lottoController;

    private Application() {
        LottoInputer lottoInputer = new ConsoleLottoInputer();
        LottoViewer lottoViewer = new ConsoleLottoViewer();

        lottoController = new LottoController(lottoInputer, lottoViewer);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void run() {
        NumberGenerator numberGenerator = new RandomLottoNumberGenerator();
        LottoTickets lottoTickets = lottoController.purchaseLottoTickets(numberGenerator);
        lottoController.checkResult(lottoTickets);
    }
}
