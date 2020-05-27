package lotto;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.shop.LottoPurchaseMoney;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LottoPurchaseMoney lottoPurchaseMoney = InputView.inputMoney();
        List<LottoTicket> lottoTicketList = lottoService.purchaseLottoTicket(lottoPurchaseMoney);

        ResultView resultView = new ResultView();
        resultView.printLottoTicketList(lottoTicketList);

        LottoTicket winLottoTicket = InputView.inputWinningNumbers();
        List<Integer> lottoRankList = lottoService.matchLottoTicket(lottoTicketList, winLottoTicket);
        resultView.printMatchResult(lottoRankList);
    }
}
