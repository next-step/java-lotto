package lottoGame;

import java.util.Set;

public class Main {

    public static void main(String... arg) {
        LottoGame lottoGame = new LottoGame();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int inputMoney = inputView.getInputMoney();

        lottoGame.buyLotto(inputMoney);


        resultView.printTicket(lottoGame.getLottoTicket());



        Set<Integer> winningNumbers = inputView.getWinningNumbers();

        lottoGame.inputWinningNumbers(winningNumbers);

        int bonusNumber = inputView.getBonusNumber();

        lottoGame.inputBonusNumber(bonusNumber);

        lottoGame.run();

        resultView.showResult(lottoGame);
    }
}
