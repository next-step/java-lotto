package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.strategy.GenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GenerateStrategy strategy;

    public LottoController(InputView inputView, OutputView outputView, GenerateStrategy strategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.strategy = strategy;
    }

    public void start() {
        int purchasePrice = inputView.readPurchasePrice();

        Lottos lottos = Lottos.of(purchasePrice, strategy);

        outputView.printLottoCount(lottos.size());
        outputView.printLottos(lottos.lottos());

        List<Integer> jackpotNumber = inputView.readJackpotNumber();
        System.out.println(jackpotNumber);

        int bonusNumber = inputView.readBonusNumber();

        Lotto jackpot = Lotto.of(LottoNumbers.of(jackpotNumber));
        outputView.printSummary(lottos.match(jackpot, LottoNumber.of(bonusNumber)));
    }
}

