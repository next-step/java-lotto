package lotto.ui;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.rank.RankCalculator;
import lotto.domain.rank.Ranks;
import lotto.domain.shop.Money;
import lotto.domain.shop.Shop;

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

        LottoTickets lottoTickets = Shop.sellLottoTicketsAutoAndManual(manualLottoTickets, boughtMoney);

        BuyOutputView buyOutputView = new BuyOutputView(lottoTickets,
                buyManualInputView.getManualLottoCount(), boughtMoney);
        buyOutputView.printResult();

        Scanner rankInputScanner = new Scanner(System.in);
        RankInputView rankInputView = RankInputView.getThisWeekWinningInfo(rankInputScanner);
        LottoTicket winTicket = rankInputView.convertToWinTicket();
        LottoNumber winBonusNumber = rankInputView.getWinBonusNumber();

        Ranks ranks = lottoTickets.calculateRanks(new RankCalculator(winTicket, winBonusNumber));
        RankOutputView rankOutputView = new RankOutputView(ranks);
        rankOutputView.printRankStatistics(boughtMoney);
    }
}
