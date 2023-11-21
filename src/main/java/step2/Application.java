package step2;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        int ticketMoney = new InputView().readIntInput("구입금액을 입력해 주세요.");
        List<LottoTicket> lottoTickets = new LottoIssuer().issueTicketsByMoney(ticketMoney);
        ResultView resultView = new ResultView();
        resultView.printLottoCount(lottoTickets);
        resultView.printLottoTickets(lottoTickets);

        LottoTicket winningTicket = new LottoTicket(new InputView().readStringInput("지난 주 당첨 번호를 입력해 주세요."));
        LottoResult lottoResult = new LottoResult(lottoTickets, winningTicket);

        resultView.printLottoResult(ticketMoney, lottoResult);
    }
}
