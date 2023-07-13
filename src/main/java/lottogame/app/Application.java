package lottogame.app;

import lottogame.console.ConsoleInputer;
import lottogame.console.ConsoleViewer;
import lottogame.controller.LottoController;
import lottogame.controller.spi.Inputer;
import lottogame.controller.spi.Viewer;
import lottogame.domain.spi.NumberGenerator;
import lottogame.randomnumber.RandomLottoNumberGenerator;

public class Application {

    public static void main(String[] args) {
        Inputer inputer = new ConsoleInputer();
        Viewer viewer = new ConsoleViewer();
        NumberGenerator numberGenerator = new RandomLottoNumberGenerator();
        LottoController lottoController = new LottoController(inputer, viewer, numberGenerator);
        lottoController.run();
    }
}
