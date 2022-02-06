package lotto;

import java.util.List;
import lotto.domain.Analyzer;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoProcessor {

    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        try {
            int payment = inputView.getPayment();
            LottoTickets lottoTickets = new LottoTickets(payment);

            int ticketCounts = lottoTickets.getTicketCounts();

            resultView.printNumberOfLotto(ticketCounts);
            resultView.printLottoTickets(lottoTickets.getLottoTickets());

            List<Integer> winningNumbers = inputView.getWinningNumbers();
            int bonusNumber = inputView.getBonusNumber();

            LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusNumber);

            List<Integer> numberOfMatches = lottoTickets.countNumberOfMatches(lottoMachine);
            List<Integer> bonusNumbers = lottoTickets.checkBonusNumber(lottoMachine);

            Analyzer analyzer = new Analyzer(payment);
            analyzer.calculateTotalPrizeMoney(numberOfMatches, bonusNumbers);

            double profitPercent = analyzer.calculateProfitPercent();
            resultView.printAnalyzeResults(analyzer.getRankings(), profitPercent);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}