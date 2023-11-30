package lotto.config;

import java.util.Scanner;
import lotto.controller.LottoController;
import lotto.domain.AutomaticLottoMachine;
import lotto.domain.LottoRandomNumberStrategy;
import lotto.domain.ManualLottoMachine;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.RandomNumberStrategy;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoFactory {
    public LottoController lottoController() {
        return new LottoController(lottoService(), inputView(), outputView());
    }

    private LottoService lottoService() {
        return new LottoService(manualLottoMachine(), automaticLottoMachine());
    }

    private ManualLottoMachine manualLottoMachine() {
        return new ManualLottoMachine();
    }

    private AutomaticLottoMachine automaticLottoMachine() {
        return new AutomaticLottoMachine(randomLottoGenerator());
    }

    private RandomLottoGenerator randomLottoGenerator() {
        return new RandomLottoGenerator(randomNumberStrategy());
    }

    private RandomNumberStrategy randomNumberStrategy() {
        return new LottoRandomNumberStrategy();
    }

    private InputView inputView() {
        return new InputView(scanner());
    }

    private Scanner scanner() {
        return new Scanner(System.in);
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
