package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoRandomMachine;
import lotto.domain.LottoTickets;
import lotto.domain.ResultLotto;
import lotto.domain.Shop;
import lotto.domain.Wallet;
import lotto.dto.AssignBuyPreTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameMain {

    public static void main(String[] args) {

        InputView inputView = InputView.create();
        Wallet wallet = inputView.inputMoney();

        AssignBuyPreTicket assignBuyPreTicket = inputView.inputAssignNumberCount(wallet);// 갯수는도 저장해야 하는데?
        LottoTickets lottoTickets1 = inputView.inputAssignNumber(assignBuyPreTicket);

        Shop shop = new Shop();
        LottoTickets lottoTickets = shop.buy(wallet, new LottoRandomMachine()); // TODO: assignBuyPreTicket().getWallet() 으로 변경해야 하는가? 2021/12/04 (kiyeon_kim1)

        OutputView outputView = new OutputView();
        outputView.printBuyCountMessage(lottoTickets);
        ResultLotto resultLotto = inputView.inputLottoResultNumber();

        GameResult result = shop.result(lottoTickets, resultLotto);
        outputView.printByResult(result);

    }

}
