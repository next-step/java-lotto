package lotto;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.purchaseAndGetResult();
    }

    public void purchaseAndGetResult() {
        int lottoTicketCount = inputView.getInputAndPrint();
        LottoTickets lottoTickets = new LottoTickets(issue(lottoTicketCount));

        resultView.getResultAndPrint(lottoTickets);
    }

    private List<LottoTicket> issue(int lottoTicketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();

        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTickets.add(lottoTicketGenerator.getAuto());
        }

        return lottoTickets;
    }

}
