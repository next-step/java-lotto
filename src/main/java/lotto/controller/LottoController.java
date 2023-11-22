package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.strategy.RandomStrategy;
import lotto.domain.summary.Summary;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.UserInput;

import static lotto.domain.lotto.Lottos.PRICE_PER_TICKET;

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
        UserInput userInput = userInput();

        Lottos manualLottos = manualLottos(userInput);
        Lottos autoLottos = autoLottos(remainingPurchasePrice(userInput));

        Lottos lottos = Lottos.concat(manualLottos, autoLottos);

        outputView.printLottoCount(manualLottos.size(), autoLottos.size());
        outputView.printLottos(lottos.lottos());
        outputView.printSummary(summary(lottos));
    }

    private UserInput userInput() {
        return new UserInput(inputView.readPurchasePrice(), inputView.readManualLottoCount());
    }

    private Lottos manualLottos(UserInput userInput) {
        return Lottos.of(userInput.purchasePrice(), inputView.readManualLotto(userInput.manualLottoCount()));
    }

    private int remainingPurchasePrice(UserInput userInput) {
        return userInput.purchasePrice() - userInput.manualLottoCount() * PRICE_PER_TICKET;
    }

    private Lottos autoLottos(int remainingPurchasePrice) {
        return Lottos.of(remainingPurchasePrice, new RandomStrategy());
    }

    public Summary summary(Lottos lottos) {
        return lottos.match(jackpotLotto(), bonusNumber());
    }

    private Lotto jackpotLotto() {
        return Lotto.of(inputView.readJackpotNumber());
    }

    private LottoNumber bonusNumber() {
        return LottoNumber.of(inputView.readBonusNumber());
    }
}

