package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.strategy.RandomStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
    }

    public void play() {
        int purchasePrice = inputView.readPurchasePrice();
        int manualLottoCount = inputView.readManulLottoCount();
        int remainingPurchasePrice = remainingPurchasePrice(purchasePrice, manualLottoCount);

        Lottos.validate(purchasePrice, manualLottoCount);

        List<List<Integer>> lists = inputView.readManualLotto(manualLottoCount);

        Lottos manualLottos = Lottos.of(purchasePrice, lists);
        Lottos autoLottos = Lottos.of(remainingPurchasePrice, new RandomStrategy());

        Lottos lottos = Lottos.concat(manualLottos, autoLottos);

        outputView.printLottoCount(manualLottos.size(), autoLottos.size());
        outputView.printLottos(lottos.lottos());

        List<Integer> jackpotNumber = inputView.readJackpotNumber();
        System.out.println(jackpotNumber);

        int bonusNumber = inputView.readBonusNumber();

        Lotto jackpot = Lotto.of(jackpotNumber);
        outputView.printSummary(lottos.match(jackpot, LottoNumber.of(bonusNumber)));
    }

    private int remainingPurchasePrice(int purchasePrice, int manualLottoCount) {
        return purchasePrice - manualLottoCount * PRICE_PER_TICKET;
    }
}

