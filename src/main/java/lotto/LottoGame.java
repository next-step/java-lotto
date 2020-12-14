package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        LottoTicketCount lottoTicketCount = LottoTicketCount.getInstance(money);

        LottoShop lottoShop = LottoShop.getInstance();
        PublishedLottoTicket publishedLottoTicket = lottoShop.buyLotto(money);

        OutputView.printPublishedLottoResult(lottoTicketCount, publishedLottoTicket);

        List<Integer> winningLottoNumbers = InputView.inputWinningLottoNumbers();
        WinningLotto winningLotto = WinningLotto.ofLottoNumbers(LottoMachine.createManualLottoNumbers(winningLottoNumbers));

        LottoResult lottoResult = LottoResult.getInstance();
        lottoResult.analyzeLottoRank(publishedLottoTicket.getPublishedLottoTicket(), winningLotto);

        OutputView.printLottoStatics(lottoResult, lottoResult.calculatePrizeRate(money));
    }

}
