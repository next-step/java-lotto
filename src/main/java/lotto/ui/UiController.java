package lotto.ui;

import lotto.application.LottoService;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.rank.Ranks;
import lotto.domain.shop.Money;

import java.util.Scanner;

public class UiController {
    public static void main(String[] args) {
        Scanner buyInputScanner = new Scanner(System.in);
        BuyInputView inputViewByConsole = BuyInputView.createByConsole(buyInputScanner);
        Money boughtMoney = inputViewByConsole.getMoney();

        Scanner manualCounterScanner = new Scanner(System.in);
        BuyManualInputView buyManualInputView = BuyManualInputView.getManualLottoCount(manualCounterScanner);
        Scanner manualValuesScanner = new Scanner(System.in);
        buyManualInputView.getInputValues(manualValuesScanner);
        LottoTickets manualLottoTickets = buyManualInputView.convertToManualLottoTickets();

        LottoService lottoService = new LottoService();
        LottoTickets lottoTickets = lottoService.buyLottoTicketsCombine(manualLottoTickets, boughtMoney);

        BuyOutputView buyOutputView = new BuyOutputView(lottoTickets);
        buyOutputView.printResult();

        Scanner rankInputScanner = new Scanner(System.in);
        RankInputView rankInputView = RankInputView.getThisWeekWinningInfo(rankInputScanner);
        LottoTicket winTicket = rankInputView.convertToWinTicket();
        LottoNumber winBonusNumber = rankInputView.getWinBonusNumber();
        
        Ranks ranks = lottoService.calculateRank(winTicket, winBonusNumber, lottoTickets);
        RankOutputView rankOutputView = new RankOutputView(ranks);
        rankOutputView.printRankStatistics(boughtMoney);
    }
}
