package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.strategy.GenerateStrategy;
import lotto.dto.Summary;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public LottoController(InputView inputView, OutputView outputView, GenerateStrategy strategy) {
        Integer purchasePrice = inputView.readPurchasePrice();

        Lottos lottos = Lottos.of(purchasePrice, strategy);

        outputView.printLottoCount(lottos.size());
        outputView.printLottos(lottos.lottos());

        List<Integer> jackpotNumber = inputView.readJackpotNumber();
        System.out.println(jackpotNumber);
        
        Lotto jackpot = Lotto.of(() -> jackpotNumber);
        outputView.printSummary(lottos.match(jackpot));
    }
}

