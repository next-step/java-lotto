package lotto;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void main(String[] args) {
        LottoMoney lottoMoney = LottoMoney.of(InputView.scanLottoMoney());

        LottoTickets lottoTickets = LottoTickets.of(lottoMoney.getBuyCount());
        OutputView.printLottoTickets(lottoTickets);

        WinningLotto winningLotto = WinningLotto.of(InputView.scanWinningLottoNumber());
        WinningResult winningResult = lottoTickets.getWinningResult(winningLotto);
        OutputView.printLottoResult(winningResult);
    }
}
