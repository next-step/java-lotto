package step3.controller;

import step3.domain.LottoTicket;
import step3.domain.LottoTickets;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class Operation {
    public static void operation() throws IllegalAccessException {
        int count = InputView.input();
        LottoService lottoService = new LottoService();
        LottoTickets lottoTicketList =  lottoService.createLottoTicket(count);
        ResultView.view(lottoTicketList);

        String numbers = InputView.inputNumber();
        Long bonusNo = InputView.inputBonusNumber();

        List<Rank> ranks = FindMatchNumber.find(lottoTicketList, numbers, bonusNo);

        ResultView.result(Rank.revenue(ranks), Rank.result(ranks));

    }
}
