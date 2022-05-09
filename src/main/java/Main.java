import application.LottoService;
import application.StatisticService;
import domain.LottoTicket;
import domain.WinStatistic;
import util.OperationUtil;
import view.InputView;
import view.ResultView;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StatisticService statisticService = new StatisticService();

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int purchasedAmount = inputView.getPurchasedAmount();
        int numOfTickets = OperationUtil.getNumberOfPurchasedTickets(purchasedAmount);
        inputView.printAmount(numOfTickets);

        List<LottoTicket> lottoTickets = new LinkedList<>();
        getPurchasedLottoResult(lottoTickets, numOfTickets);

        String lastWinningNumbers = inputView.printPurchasedLottoTickets();
        List<Integer> winningNumbers = OperationUtil.splitStringToNumbers(lastWinningNumbers);

        List<WinStatistic> statistics = statisticService.initiateStatistics();

        for (int i = 0; i < numOfTickets; i++) {
            int result = statisticService.getNumberOfMatches(lottoTickets.get(i), winningNumbers);
            findLottoWin(statistics, result);
        }
        resultView.printWinResult(statistics);
        getRateOfReturn(statistics, purchasedAmount);
    }

    public static void findLottoWin(List<WinStatistic> statistics, int result) {
        WinStatistic jackpot = statistics.stream()
                .filter(o -> o.getMatchingNumber() == result)
                .findFirst()
                .orElseGet(WinStatistic::new);

        if (!(jackpot.isEmpty())) {
            jackpot.increaseCount();
        }
    }

    public static void getPurchasedLottoResult(List<LottoTicket> lottoTickets, int numOfTickets) {
        LottoService lottoService = new LottoService();
        ResultView resultView = new ResultView();

        for (int i = 0; i < numOfTickets; i++) {
            lottoTickets.add(lottoService.createLottoTicket());
        }
        resultView.printAllLottoNumbers(lottoTickets);
    }

    public static void getRateOfReturn(List<WinStatistic> statistics, int purchasedAmount) {
        ResultView resultView = new ResultView();

        int prizeTotalAmount = statistics.stream()
                .mapToInt(o -> o.getPrizeAmount(o)).sum();

        double rateOfReturn = OperationUtil.getRateOfReturn(prizeTotalAmount, purchasedAmount);

        resultView.printRateOfReturn(rateOfReturn);
    }
}
