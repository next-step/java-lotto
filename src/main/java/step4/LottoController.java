package step4;

import step4.View.InputView;
import step4.View.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    public void start() {
        List<String> lottos = new ArrayList<>();
        LottoStore lottoStore = new LottoStore();
        Price money = new Price(inputView.inputPurchasePrice());
        int passiveCount = inputView.passivePurchase();
        inputView.passiveLottoNumberPrint();

        for (int i = 0; i <passiveCount; i++) {
            lottos.add(inputView.passiveLottoNumber());
        }

        int auto = money.lottoCount() - passiveCount;
        resultView.printPassiveAndAuto(auto, passiveCount);

        LottoGame game = new LottoGame(lottoStore.lottoGenerate(money, passiveCount, lottos));

        for (Lotto lotto : game.allLotto()) {
            resultView.printInteger(lotto);
        }

        Lotto lastWinner = inputView.inputLastInteger();
        int bonus = inputView.inputBonus();
        Map<Rank, Integer> gameMap = game.result(new LottoWinner(lastWinner, bonus));
        resultView.printSameLotto(gameMap);
        LottoYield lottoYield = new LottoYield(gameMap);
        resultView.printBenefit(lottoYield, new Price(money.getPrice()));

    }
}
