package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.strategy.RandomStrategy;
import lotto.domain.summary.Summary;
import lotto.dto.view.UserInputDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        UserInputDTO userInputDTO = userInput();

        Lottos manualLottos = manualLottos(userInputDTO);
        Lottos autoLottos = autoLottos(remainingPurchasePrice(userInputDTO));

        Lottos lottos = Lottos.concat(manualLottos, autoLottos);

        outputView.printLottoCount(manualLottos.size(), autoLottos.size());
        outputView.printLottos(lottos.lottos());
        outputView.printSummary(summary(lottos));
    }

    private UserInputDTO userInput() {
        return new UserInputDTO(inputView.readPurchasePrice(), inputView.readManualLottoCount());
    }

    private Lottos manualLottos(UserInputDTO userInputDTO) {
        return Lottos.of(userInputDTO.purchasePrice(), inputView.readManualLotto(userInputDTO.manualLottoCount()));
    }

    private int remainingPurchasePrice(UserInputDTO userInputDTO) {
        return userInputDTO.purchasePrice() - userInputDTO.manualLottoCount() * PRICE_PER_TICKET;
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

