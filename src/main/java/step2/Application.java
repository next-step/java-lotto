package step2;

import step2.domain.*;
import step2.view.ResultView;
import step2.view.InputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        int ticketMoney = new InputView().readIntInput("구입금액을 입력해 주세요.");
        List<LottoTicket> lottoTickets = new LottoIssuer().issueTicketsByMoney(ticketMoney);
        ResultView resultView = new ResultView();
        resultView.printLottoCount(lottoTickets);
        resultView.printLottoTickets(lottoTickets);

        LottoTicket winningTicket = new LottoTicket(new InputView().readStringInput("지난 주 당첨 번호를 입력해 주세요."));
        LottoNumber bonusNumber = new LottoNumber(new InputView().readIntInput("보너스 볼을 입력해 주세요."));
        LottoResult lottoResult = new LottoResult(lottoTickets, new LottoWinningTicket(winningTicket, bonusNumber));

        resultView.printLottoResult(ticketMoney, lottoResult);
    }
}
