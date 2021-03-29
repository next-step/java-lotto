package lotto;

import lotto.domain.*;
import lotto.enums.WinningRank;
import lotto.utils.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        LottoTickets lottoTickets = createLottoTickets(purchaseAmount);
        printLottoTickets(lottoTickets);
        WinningNumbers winningNumbers = createWinningNumbers();
        RanksCount ranksCount = createRanksCount(winningNumbers, lottoTickets);
        printStatistics(ranksCount.ranksCount());
        ProfitRate profitRate = createProfitRate(ranksCount, purchaseAmount);
        printProfitRate(profitRate);
    }

    private static PurchaseAmount createPurchaseAmount() {
        try {
            String purchaseAmount = InputView.purchaseAmount();
            return new PurchaseAmount(purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createPurchaseAmount();
        }
    }

    private static LottoTickets createLottoTickets(PurchaseAmount purchaseAmount) {
        TicketOffice ticketOffice = new TicketOffice(new LottoTicketPrice());
        NumberOfTicket numberOfTicket = ticketOffice.numberOfTicket(purchaseAmount);
        ResultView.purchaseTickets(numberOfTicket.count());
        return ticketOffice.sale(numberOfTicket);
    }

    private static void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            ResultView.lottoNumbers(lottoTicket.lottoNumbers());
        }
    }

    private static WinningNumbers createWinningNumbers() {
        try {
            List<String> winningNumbers = SplitUtil.splitByComma(InputView.winningNumbers());
            return WinningNumbers.createBystrings(winningNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createWinningNumbers();
        }
    }

    private static RanksCount createRanksCount(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        RanksCount ranksCount = new RanksCount(winningNumbers, lottoTickets);
        ranksCount.count();
        return ranksCount;
    }

    private static void printStatistics(Map<WinningRank, Integer> ranksCount) {
        ResultView.statistics(ranksCount);
    }

    private static ProfitRate createProfitRate(RanksCount ranksCount, PurchaseAmount purchaseAmount) {
        return new ProfitRate(ranksCount.totalPrize(), purchaseAmount);
    }

    private static void printProfitRate(ProfitRate profitRate) {
        if (profitRate.isPositive()) {
            ResultView.positiveProfitRate(profitRate.profitRate());
        }

        if (!profitRate.isPositive()) {
            ResultView.negativeProfitRate(profitRate.profitRate());
        }
    }
}
