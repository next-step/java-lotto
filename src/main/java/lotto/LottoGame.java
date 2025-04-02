package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    public static void main(String[] args) {

        int money = InputView.inputMoney();

        int manualTicketCount = InputView.inputManualTicketCount();
        List<List<Integer>> manualTicketList = InputView.inputManualTicket(manualTicketCount);
        List<LottoTicket> manualTickets = manualTicketList.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());

        LottoTickets lottoTickets = new LottoTickets(money, manualTickets);

        ResultView.printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        LottoTicket winningTicket = new LottoTicket(winningNumbers);

        int bonusNumber = InputView.inputBonusNumber();
        WinningResult winningResult = new WinningResult(winningTicket, bonusNumber);
        ResultView.printResult(lottoTickets, winningResult);
    }
}
