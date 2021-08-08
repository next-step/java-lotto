package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {

        long purchaseAmount = InputView.getInputAmount();

        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        LottoShop lottoShop = new LottoShop(lottoGenerator);

        LottoTickets lottoTickets = lottoShop.buy(purchaseAmount);

        ResultView.showBuyLottoTickets(lottoTickets);

        List<Integer> winningNumbers = InputView.getWinningNumber();

        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);

        ResultView.showLottoResult(lottoStatistic, purchaseAmount);
    }
}
