package lotto.config;

import java.util.Scanner;
import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRandomNumberStrategy;
import lotto.domain.RandomNumberStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoFactory {
    public InputView inputView() {
        return new InputView(scanner());
    }

    private Scanner scanner() {
        return new Scanner(System.in);
    }

    public LottoController lottoController() {
        return new LottoController(lottoMachine());
    }

    private LottoMachine lottoMachine() {
        return new LottoMachine(lottoGenerator());
    }

    private LottoGenerator lottoGenerator() {
        return new LottoGenerator(randomNumberStrategy());
    }

    private RandomNumberStrategy randomNumberStrategy() {
        return new LottoRandomNumberStrategy();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
