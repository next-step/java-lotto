package lotto;

import lotto.domain.*;
import lotto.enums.WinningRank;
import lotto.utils.DivisionUtil;
import lotto.utils.LottoRandomNumberUtil;
import lotto.utils.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.purchaseAmount());
        int numberOfTickets = DivisionUtil.divisionByThousand(purchaseAmount);
        ResultView.purchaseTickets(numberOfTickets);
        LottoTickets lottoTickets = new LottoTickets(new ArrayList<>());

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = LottoRandomNumberUtil.lottoNumbers();
            lottoTickets.add(new LottoTicket(new LottoNumbers(lottoNumbers)));
        }

        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            ResultView.lottoNumbers(lottoTicket.lottoNumbers());
        }

        String numbers = InputView.winningNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(SplitUtil.split(numbers));
        RanksCount ranksCount = new RanksCount();
        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            int matchedCount = winningNumbers.countMatchingNumbers(lottoTicket.lottoNumbers());
            WinningRank rank = WinningRank.findByMacthedCount(matchedCount);
            ranksCount.add(rank);
        }

        ResultView.statistics(ranksCount.ranksCount());
        ProfitRate profitRate = new ProfitRate(WinningRank.totalPrize(ranksCount), purchaseAmount.purchaseAmount());
        if (profitRate.profitRate() >= 1) {
            ResultView.plusProfitRate(profitRate.profitRate());
        }
        if (profitRate.profitRate() < 1) {
            ResultView.minusProfitRate(profitRate.profitRate());
        }
    }
}
