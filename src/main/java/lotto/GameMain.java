package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoRandomMachine;
import lotto.domain.LottoTickets;
import lotto.domain.ResultLotto;
import lotto.domain.Wallet;
import lotto.dto.AssignPreTicket;
import lotto.dto.BuyTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameMain {

    public static void main(String[] args) {

        InputView inputView = InputView.create();
        Wallet wallet = inputView.inputMoney();

        AssignPreTicket assignPreTicket = inputView.inputAssignNumberCount(wallet);
        LottoTickets assignTickets = inputView.inputAssignNumber(assignPreTicket);

        BuyTickets buyTickets = assignPreTicket.getAllBuyTickets(assignTickets, new LottoRandomMachine());

        OutputView outputView = new OutputView();
        outputView.printBuyCountMessage(buyTickets);
        ResultLotto resultLotto = inputView.inputLottoResultNumber();

        GameResult result = buyTickets.result(resultLotto);
        outputView.printByResult(result);

    }

}
