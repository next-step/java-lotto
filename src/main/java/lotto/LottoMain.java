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

        LottoPurchaseMoney manualLottoPurchaseMoney = InputView.inputManualTicketCount(lottoPurchaseMoney);

        List<LottoTicket> manualLottoTicketList = InputView.inputLottoTicketNumber(manualLottoPurchaseMoney);
        List<LottoTicket> lottoTicketList = lottoService.purchaseLottoTicket(lottoPurchaseMoney);

        ResultView resultView = new ResultView();
        resultView.printLottoTicketList(lottoTicketList, manualLottoTicketList);

        LottoTicket winLottoTicket = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();

        manualLottoTicketList.addAll(lottoTicketList);
        LottoRankCalculator lottoRankCalculator = new LottoRankCalculator(winLottoTicket, bonusNumber);
        List<LottoRank> lottoRankList = lottoService.matchLottoTicket(manualLottoTicketList, lottoRankCalculator);
        resultView.printMatchResult(lottoRankList);
    }
}
