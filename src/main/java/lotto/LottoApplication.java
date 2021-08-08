package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {

        long purchaseAmount = InputView.getInputAmount();

        LottoShop lottoShop = new LottoShop();
        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        LottoTickets lottoTickets = lottoShop.buy(purchaseAmount, lottoGenerator);

        ResultView.showBuyLottoTickets(lottoTickets);

        List<Integer> winningNumbers = InputView.getWinningNumber();

        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);

        ResultView.showLottoResult(lottoStatistic, purchaseAmount);
    }
}
