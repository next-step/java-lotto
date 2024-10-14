package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        System.out.println();
        String inputWinningNumbers = inputView.inputWinningNumbers();

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<Integer> matchingCountResult = lottoMachine.checkMatchingNumber(inputWinningNumbers);

        Map<Integer, Integer> matchingResult = lottoMachine.winningResult(matchingCountResult);

        for (int i = 3; i <= 6; i++) {
            int matchingTicketCount = matchingResult.getOrDefault(i, 0); // 기본값 0L
            System.out.println(i + "개 일치 - " + matchingTicketCount + "개");
        }
    }

}
