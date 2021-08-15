package lotto;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printOpening();
        int price = Integer.parseInt(inputView.getNumber());

        LottoGame lottoGame = new LottoGame(price);

        outputView.printGameNum(lottoGame.getGameNum());
        outputView.printTickets(lottoGame.getLottoGame());
        outputView.printLastWinningNumber();

        lottoGame.setWinningNumber(inputView.getNumber());
        lottoGame.checkResult();
        lottoGame.setResult();

        outputView.printResult(lottoGame.getResult());
        outputView.printProfitValue(lottoGame.getProfitRate());

    }

}
