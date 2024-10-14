package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoDisplay {
    private static final InputView inputView = new InputView();
    private static final Cashier cashier = new Cashier();
    private static final ResultView resultView = new ResultView();
    private static final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int totalMoney = inputView.inputTotalAmount();
        int totalTicketCount = cashier.makeLottoGamePapers(totalMoney);
        System.out.println(resultView.printTotalLottoTicketCount(totalTicketCount));

        List<Lotto> totalLottoTickets = lottoMachine.makeTotalLottoTickets(totalTicketCount);
        totalLottoTickets.stream()
                .forEach(System.out::println);
    }

}
