package step5;

import step5.domain.*;
import step5.domain.lottoticket.ManualLottoTicket;
import step5.domain.lottoticket.WinningLottoTicket;
import step5.view.InputView;
import step5.view.ResultView;

public class LottoApp {

    public static void main(String[] args) {
        Lotto lotto = new Lotto(InputView.requirePurchaseAmount());
        lotto.buyManually(InputView.requireNumberOfManualLotto());

        LottoTickets lottoTickets = new LottoTickets();
        buyLotto(lotto, lottoTickets);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(
            InputView.requireLastWinningLottoNumber(), InputView.requireBonusBall());
        lottoTickets.match(winningLottoTicket);

        ResultView.printPurchaseLottoInfo(lotto.manual(), lotto.auto());
        ResultView.printLottoNumberInfo(lottoTickets);
        ResultView.printResult(lottoTickets.lottoResult(), lotto.money());
    }

    private static void buyLotto(Lotto lotto, LottoTickets lottoTickets) {
        for (int i = 0; i < lotto.manual(); i++) {
            lottoTickets
                .buyLottoManually(new ManualLottoTicket(InputView.requireManualLottoNumber()));
        }
        lottoTickets.buyLottoAutomatically(lotto.auto());
    }
}
