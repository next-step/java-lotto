package lotto;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRankCalculator;
import lotto.domain.shop.LottoPurchaseMoney;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LottoPurchaseMoney lottoPurchaseMoney = InputView.inputMoney();

        LottoPurchaseMoney changeLottoPurchaseMoney = InputView.inputManualTicketCount(lottoPurchaseMoney);


        List<LottoTicket> lottoTicketList = lottoService.purchaseLottoTicket(changeLottoPurchaseMoney);

        ResultView resultView = new ResultView();
        resultView.printLottoTicketList(lottoTicketList);

        LottoTicket winLottoTicket = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();

        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator(winLottoTicket, bonusNumber);
        List<LottoRank> lottoRankList = lottoService.matchLottoTicket(lottoTicketList, lottoRankCalculator);
        resultView.printMatchResult(lottoRankList);
    }
}
