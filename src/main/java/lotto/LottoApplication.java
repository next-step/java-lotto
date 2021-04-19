package lotto;

import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Number;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Money buyMoney = new Money(inputView.getBuyLottoAmount());

        LottoGame lottoGame = new LottoGame();

        lottoGame.initializeStatistics();
        lottoGame.buyLotto(buyMoney);

        outputView.printBoughtLottoCount(lottoGame.getLottos().size());
        outputView.printLottoNumbers(lottoGame.getLottos());
        outputView.printLine();

        Lotto winningLotto = new Lotto(inputView.getLastWinningNumbers());
        Number bonusNumber = new Number(inputView.getBonusNumber());
        lottoGame.lastWinningLotto(winningLotto);
        lottoGame.setBonusNumber(bonusNumber);

        lottoGame.lottoWinners();
        outputView.printLottoStatistics(lottoGame.getLottoGameStatistics());
        outputView.printProfit(lottoGame.getProfit());

    }
}

