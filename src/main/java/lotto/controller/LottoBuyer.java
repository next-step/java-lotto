package lotto.controller;

import lotto.model.LottoTicket;
import lotto.model.LottoTicketOffice;
import lotto.model.WinningIdentifier;
import lotto.model.WinningReport;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoBuyer {

    public void buy() {
        // 로또 구입
        int purchaseAmount = InputView.readPurchaseAmount();
        List<LottoTicket> lottoTickets = new LottoTicketOffice().buyLotto(purchaseAmount);
        OutputView.printLottoTickets(lottoTickets);

        // 당첨 번호 입력
        LottoTicket winningTicket = InputView.readWinningNumber();

        // 통계 출력
        WinningReport winningReport = new WinningIdentifier(winningTicket).checkTicketsWinning(lottoTickets);
        OutputView.printReport(winningReport);
    }

}
