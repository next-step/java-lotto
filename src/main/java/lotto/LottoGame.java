package lotto;

import lotto.domain.LottoService;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lottoPrice = InputView.setPayPriceLotto(scanner);

        LottoService lottoService = new LottoService();
        int lottoTicketQuantity = lottoService.buyLottoTicket(lottoPrice);
        InputView.printLottoBuyQuantity(lottoTicketQuantity);

        LottoTickets lottoTickets = new LottoTickets(lottoTicketQuantity);
        InputView.printLottoTickets(lottoTickets);

        String inputWinningNumber = InputView.setWinningNumber(scanner);
        WinningNumber winningNumber = new WinningNumber();
        List<Integer> winningNumbers = winningNumber.setWinningNumber(inputWinningNumber);

        WinningResult winningResult = new WinningResult().matchWinningNumber(winningNumber, winningNumbers, lottoTickets);
        ResultView.printWinningNumericalStatement();
        ResultView.printLottoResult(winningResult);
    }
}
