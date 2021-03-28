package lotto;

import lotto.domain.*;
import lotto.enums.WinningRank;
import lotto.utils.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
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
        NumberOfTicket numberOfTicket = purchaseAmount.numberOfTicket(new LottoTicketPrice().price());
        ResultView.purchaseTickets(numberOfTicket.count());
        LottoTickets lottoTickets = new LottoTickets(new ArrayList<>());

        for (int i = 0; i < numberOfTicket.count(); i++) {
            lottoTickets.add(new LottoTicket(new LottoNumbers()));
        }

        return lottoTickets;
    }

    private static void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            ResultView.lottoNumbers(lottoTicket.lottoNumbers());
        }
    }

    private static WinningNumbers createWinningNumbers() {
        try {
            List<String> winningNumbers = SplitUtil.split(InputView.winningNumbers());
            return new WinningNumbers(winningNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createWinningNumbers();
        }
    }

    private static RanksCount createRanksCount(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        RanksCount ranksCount = new RanksCount();

        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            MatchedCount matchedCount = winningNumbers.countMatchingNumbers(lottoTicket.lottoNumbers());
            WinningRank rank = WinningRank.findByMacthedCount(matchedCount.matchedCount());
            ranksCount.add(rank);
        }

        return ranksCount;
    }

    private static void printStatistics(Map<WinningRank, Integer> ranksCount) {
        ResultView.statistics(ranksCount);
    }

    private static ProfitRate createProfitRate(RanksCount ranksCount, PurchaseAmount purchaseAmount) {
        return new ProfitRate(new TotalPrize(WinningRank.totalPrize(ranksCount)), purchaseAmount);
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
