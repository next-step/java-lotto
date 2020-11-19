package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {

        int purchasePrice = InputView.inputPurchasePrice();
        LottoTicket ticket = LottoShop.purchase(purchasePrice);
        ResultView.outputPurchaseQuantity(ticket.getTicketQuantity());

        Lottos lottos = LottoShop.exchangeToLotto(ticket, new LottoAutoMachine());
        ResultView.outputExchangeLottos(lottos);

        List<Integer> prizeNumbers = InputView.lastWeekLottoPrizeNumber();
        lottos.matchPrizeNumber(prizeNumbers);

        ResultView.outputPrizeStatistics(lottos.getReward());
        ResultView.outputTotalEarningRate(lottos.getReward(), purchasePrice);

    }
}
