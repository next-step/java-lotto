package lotto;

import lotto.domain.LottoTicket;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();

        LottoMachine lottoMachine = new LottoMachine(consoleView);
        List<LottoTicket> lottoTickets = lottoMachine.buyLotto();

        LottoResultReader lottoResultReader = new LottoResultReader(consoleView);
        lottoResultReader.readResult(lottoTickets);
    }
}
