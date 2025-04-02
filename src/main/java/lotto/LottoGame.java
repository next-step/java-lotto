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

        List<LottoTicket> manualTickets = toLottoTickets(manualTicketList);

        LottoTickets lottoTickets = new LottoTickets(money, manualTickets);

        ResultView.printLottoTickets(lottoTickets);

        List<Integer> winningNumberList = InputView.inputWinningNumbers();
        List<LottoNumber> winningNumbers = toLottoNumbers(winningNumberList);
        LottoTicket winningTicket = new LottoTicket(winningNumbers);

        int bonusNumberValue = InputView.inputBonusNumber();
        LottoNumber bonusNumber = new LottoNumber(bonusNumberValue);
        WinningResult winningResult = new WinningResult(winningTicket, bonusNumber);
        ResultView.printResult(lottoTickets, winningResult);
    }

    private static List<LottoTicket> toLottoTickets(List<List<Integer>> manualTicketList) {
        return manualTicketList.stream()
                .map(ticket -> ticket.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()))
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> manualTicket) {
        return manualTicket.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
