package lotto.ui;

import lotto.application.LottoService;
import lotto.domain.lotto.LottoTickets;

import java.util.Scanner;

public class UiController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BuyInputView inputViewByConsole = BuyInputView.createByConsole(scanner);

        LottoService lottoService = new LottoService();
        LottoTickets lottoTickets = lottoService.buyLottoTickets(inputViewByConsole.getMoney());

        BuyOutputView buyOutputView = new BuyOutputView(lottoTickets);
        buyOutputView.printResult();
    }
}
