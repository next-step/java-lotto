package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void main(String[] args) {
        BuyCount buyCount = BuyCount.of(InputView.scanLottoMoney());

        LottoTickets lottoTickets = LottoTickets.of(buyCount, new LottoTicketRandomMaker());
        OutputView.printLottoTickets(lottoTickets);

        WinningLotto winningLotto = WinningLotto.of(InputView.scanWinningLottoNumber());
        WinningResult winningResult = lottoTickets.getWinningResult(winningLotto);
        OutputView.printLottoResult(winningResult);
    }
}
