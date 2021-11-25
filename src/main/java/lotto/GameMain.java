package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoRandomMachine;
import lotto.domain.LottoTickets;
import lotto.domain.ResultLotto;
import lotto.domain.Shop;
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
