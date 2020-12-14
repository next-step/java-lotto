package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        Money lottoMoney = new Money(InputView.inputMoney());
        LottoTicketCount lottoTicketCount = LottoTicketCount.getInstance(lottoMoney.getMoney());

        LottoShop lottoShop = LottoShop.getInstance();
        PublishedLottoTicket publishedLottoTicket = lottoShop.buyLotto(lottoMoney.getMoney());

        OutputView.printPublishedLottoResult(lottoTicketCount, publishedLottoTicket);

        List<Integer> winningLottoNumbers = InputView.inputWinningLottoNumbers();
        WinningLotto winningLotto = WinningLotto.ofLottoNumbers(LottoMachine.createManualLottoNumbers(winningLottoNumbers));

        LottoResult lottoResult = LottoResult.getInstance();
        lottoResult.analyzeLottoRank(publishedLottoTicket.getPublishedLottoTicket(), winningLotto);

        OutputView.printLottoStatics(lottoResult, lottoResult.calculatePrizeRate(lottoMoney.getMoney()));
    }

}
