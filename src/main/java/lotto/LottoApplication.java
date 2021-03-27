package lotto;

import lotto.domain.*;
import lotto.enums.WinningRank;
import lotto.utils.LottoRandomNumberUtil;
import lotto.utils.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = createPurchaseAmount(InputView.purchaseAmount());
        LottoTickets lottoTickets = createLottoTickets(purchaseAmount);
        printLottoTickets(lottoTickets);
        WinningNumbers winningNumbers = createWinningNumbers(SplitUtil.split(InputView.winningNumbers()));
        RanksCount ranksCount = createRanksCount(winningNumbers, lottoTickets);
        printStatistics(ranksCount.ranksCount());
        ProfitRate profitRate = createProfitRate(ranksCount, purchaseAmount);
        printProfitRate(profitRate);
    }

    private static PurchaseAmount createPurchaseAmount(String amount) {
        return new PurchaseAmount(amount);
    }

    private static LottoTickets createLottoTickets(PurchaseAmount purchaseAmount) {
        NumberOfTicket numberOfTicket = purchaseAmount.numberOfTicket(new LottoTicketPrice().price());
        ResultView.purchaseTickets(numberOfTicket.count());
        LottoTickets lottoTickets = new LottoTickets(new ArrayList<>());

        for (int i = 0; i < numberOfTicket.count(); i++) {
            List<Integer> lottoNumbers = LottoRandomNumberUtil.lottoNumbers();
            lottoTickets.add(new LottoTicket(new LottoNumbers(lottoNumbers)));
        }

        return lottoTickets;
    }

    private static void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            ResultView.lottoNumbers(lottoTicket.lottoNumbers());
        }
    }

    private static WinningNumbers createWinningNumbers(List<String> numbers) {
        return new WinningNumbers(numbers);
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
