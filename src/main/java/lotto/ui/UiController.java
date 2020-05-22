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

        LottoService lottoService = new LottoService();
        Money boughtMoney = inputViewByConsole.getMoney();
        LottoTickets lottoTickets = lottoService.buyLottoTickets(boughtMoney);

        BuyOutputView buyOutputView = new BuyOutputView(lottoTickets);
        buyOutputView.printResult();

        Scanner prizeInputScanner = new Scanner(System.in);
        PrizeInputView prizeInputView = PrizeInputView.getThisWeekWinningInfo(prizeInputScanner);
        LottoTicket winTicket = prizeInputView.convertToWinTicket();
        LottoNumber winBonusNumber = prizeInputView.getWinBonusNumber();
        Ranks ranks = lottoService.calculateRank(winTicket, winBonusNumber, lottoTickets);

        PrizeOutputView prizeOutputView = new PrizeOutputView(ranks);
        prizeOutputView.printPrizeStatistics(boughtMoney);
    }
}
