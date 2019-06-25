package step2;

import step2.domain.LottoRank;
import step2.domain.LottoSeller;
import step2.domain.LottoTicket;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {
        final int inputMoney = InputView.askMoneyToInput();
        final int numberOfTicketsToBuy = LottoSeller.countLottoTickets(inputMoney);

        OutputView.printNumberOfLottoTickets(numberOfTicketsToBuy);

        List<LottoTicket> lottoTickets = LottoSeller.issueLottoTicket(numberOfTicketsToBuy);
        OutputView.printLottoTickets(lottoTickets);

        LottoTicket luckyNumber = LottoSeller.getLuckyNumber(InputView.askLuckyNumber());
        Map<LottoRank, List<LottoTicket>> lottoResultMap = LottoSeller.getLottoResult(lottoTickets, luckyNumber);

        OutputView.printResult(lottoResultMap, numberOfTicketsToBuy);
    }
}

