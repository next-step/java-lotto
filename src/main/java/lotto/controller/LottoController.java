package lotto.controller;

import lotto.domain.lotto.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.UserInput;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            play();
        } catch (NumberFormatException e) {
            System.out.println("ERROR : " + "숫자만 입력 가능합니다.");
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
    }

    public void play() {
        UserInput userInput = new UserInput(inputView);

        Lottos manualLottos = userInput.manualLottos();
        Lottos autoLottos = userInput.autoLottos();

        Lottos lottos = Lottos.concat(manualLottos, autoLottos);

        outputView.printLottoCount(manualLottos.size(), autoLottos.size());
        outputView.printLottos(lottos.lottos());
        outputView.printSummary(userInput.summary(lottos));
    }
}

