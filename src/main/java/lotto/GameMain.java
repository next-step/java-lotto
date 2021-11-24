package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class GameMain {

    public static void main(String[] args) {

        InputView inputView = InputView.create();
        int money = inputView.inputMoney();

        Shop shop = new Shop();
        LottoTickets lottoTickets = shop.buy(money, new LottoRandomMachine());

        OutputView outputView = new OutputView();
        outputView.printBuyCountMessage(lottoTickets);
        ResultLotto resultLotto = inputView.inputLottoResultNumber();

        GameResult result = shop.result(lottoTickets, resultLotto);
        outputView.printByResult(result);

    }

}
