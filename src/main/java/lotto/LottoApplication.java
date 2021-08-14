package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printOpening();
        int price = Integer.parseInt(inputView.getNumber());

        Lotto lotto = new Lotto(price);
        outputView.printGameNum(lotto.getGameNum());

        outputView.printTickets(lotto.getLottoGame());

        outputView.printLastWinningNumber();
        lotto.setWinningNumber(inputView.getNumber());
        lotto.checkResult();
        lotto.setResult();
        outputView.printResult(lotto.getResult());
        outputView.printProfitValue(lotto.getProfitRate());

    }

}
