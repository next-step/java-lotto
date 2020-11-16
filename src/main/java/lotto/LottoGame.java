package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoGame {

    public static void main(String[] args) {

        int purchasePrice = InputView.inputPurchasePrice();
        LottoTicket ticket = LottoShop.purchase(purchasePrice);
        ResultView.outputPurchaseQuantity(ticket.getTicketQuantity());

        Lottos lottos = LottoShop.exchangeToLotto(ticket, new LottoAutoMachine());
        ResultView.outputExchangeLottos(lottos);

        List<Integer> prizeNumbers = InputView.lastWeekLottoPrizeNumber();
        Map<PrizeStatus, Integer> prizeStatuses = lottos.matchPrizeNumber(prizeNumbers);
        ResultView.outputPrizeStatistics(prizeStatuses);

        ResultView.outputTotalEarningRate(lottos, purchasePrice);

    }
}
