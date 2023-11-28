package lotto.config;

import java.util.Scanner;
import lotto.controller.LottoController;
import lotto.domain.RandomLottoGenerator;
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
        return new LottoMachine(randomLottoGenerator());
    }

    private RandomLottoGenerator randomLottoGenerator() {
        return new RandomLottoGenerator(randomNumberStrategy());
    }

    private RandomNumberStrategy randomNumberStrategy() {
        return new LottoRandomNumberStrategy();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
