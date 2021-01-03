package secondplacelotto.controller;


import secondplacelotto.view.LottosView;
import secondplacelotto.view.ResultView;
import secondplacelotto.model.*;
import secondplacelotto.view.InputView;

public class LottoController {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.playLotto();
    }

    public void playLotto() {
        int money = InputView.inputMoney();
        Buyer buyer = new Buyer(new Money(money));

        LottosView.viewLottos(buyer.buyLottos());

        String winningNumber = InputView.inputWinningNumbers();
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);

        buyer.matchLottos(winningNumbers);

        ResultView.viewStatistics();
        ResultView.viewProfitRate(ProfitCalculator.calculate(money));
    }
}
