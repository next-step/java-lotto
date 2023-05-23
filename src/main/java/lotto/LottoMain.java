package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoMain {

    public static void main(String[] args) {
        LottoTickets lottoTickets = createLottoTickets();
        ResultView.printLottoTicketCount(lottoTickets.size());
        ResultView.printLottoTickets(lottoTickets);

        List<LottoNumber> winLottoNumbers = InputView.inputWinNumber();
        LottoNumber bonusNumber = InputView.inputBonusNumber();

        LottoGame lottoGame = new LottoGame(lottoTickets, new WinningTicket(new LottoTicket(winLottoNumbers), bonusNumber));
        LottoResult lottoResult = lottoGame.playLotto();

        ResultView.printWinResult(lottoResult);
        ResultView.printWinRate(lottoResult, lottoTickets);
    }

    private static LottoTickets createLottoTickets() {
        String strLottoCost = InputView.inputLottoCost();
        Cost cost = new Cost(new Money(Integer.parseInt(strLottoCost)));

        int ticketCount = cost.getLottoTicketCount();
        int manualTicketCount = InputView.inputManualTicketCount();
        int autoTicketCount = ticketCount - manualTicketCount;
        LottoTickets lottoTickets = LottoFactory.createLottoTickets(autoTicketCount, inputManualLottoTickets(manualTicketCount));

        ResultView.printLottoTicketCountOfEachType(manualTicketCount, autoTicketCount);
        return lottoTickets;
    }

    private static List<LottoTicket> inputManualLottoTickets(int manualTicketCount) {
        InputView.printManualTicketGuideMessage();
        List<LottoTicket> lottoTickets = IntStream.rangeClosed(1, manualTicketCount)
                .mapToObj(i -> new LottoTicket(InputView.inputManualTicketNumbers()))
                .collect(Collectors.toList());

        System.out.println();
        return lottoTickets;
    }
}
