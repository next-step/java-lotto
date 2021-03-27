package lotto;

import lotto.domain.*;
import lotto.enums.WinningRank;
import lotto.utils.LottoRandomNumberUtil;
import lotto.utils.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.purchaseAmount());
        NumberOfTicket numberOfTicket = purchaseAmount.numberOfTicket(new LottoTicketPrice().price());
        ResultView.purchaseTickets(numberOfTicket.count());
        LottoTickets lottoTickets = new LottoTickets(new ArrayList<>());

        for (int i = 0; i < numberOfTicket.count(); i++) {
            List<Integer> lottoNumbers = LottoRandomNumberUtil.lottoNumbers();
            lottoTickets.add(new LottoTicket(new LottoNumbers(lottoNumbers)));
        }

        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            ResultView.lottoNumbers(lottoTicket.lottoNumbers());
        }

        WinningNumbers winningNumbers = new WinningNumbers(SplitUtil.split(InputView.winningNumbers()));
        RanksCount ranksCount = new RanksCount();
        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            int matchedCount = winningNumbers.countMatchingNumbers(lottoTicket.lottoNumbers());
            WinningRank rank = WinningRank.findByMacthedCount(matchedCount);
            ranksCount.add(rank);
        }

        ResultView.statistics(ranksCount.ranksCount());
        ProfitRate profitRate = new ProfitRate(new TotalPrize(WinningRank.totalPrize(ranksCount)), purchaseAmount);
        if (profitRate.profitRate() >= 1) {
            ResultView.plusProfitRate(profitRate.profitRate());
        }
        if (profitRate.profitRate() < 1) {
            ResultView.minusProfitRate(profitRate.profitRate());
        }
    }
}
