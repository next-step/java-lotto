package lotto;

import lotto.domain.LottoService;
import lotto.domain.LottoTickets;
import lotto.view.InputView;

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
    }
}
