package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {

        InputView inputView = new InputView();

        long purchaseAmount = inputView.getInputAmount();

        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        LottoShop lottoShop = new LottoShop(lottoGenerator);

        LottoTickets lottoTickets = lottoShop.buy(purchaseAmount);

        ResultView.showBuyLottoTickets(lottoTickets);

        List<Integer> winningNumbers = inputView.getWinningNumber();

        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);

        ResultView.showLottoResult(lottoStatistic, purchaseAmount);
    }
}
