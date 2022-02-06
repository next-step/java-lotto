package lotto;

import java.util.List;
import lotto.domain.Analyzer;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoProcessor {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {

        try {
            int totalPrice = inputView.getTotalPrice();
            LottoTickets lottoTickets = new LottoTickets(totalPrice);

            int lottoCounts = lottoTickets.getLottoCounts();

            resultView.printNumberOfLotto(lottoCounts);
            resultView.printLottoTickets(lottoTickets.getLottoTickets());

            List<Integer> winNumbers = inputView.getWinNumbers();
            int bonusNumber = inputView.getBonusNumber();

            LottoMachine lottoMachine = new LottoMachine(winNumbers, bonusNumber);
            List<Integer> integers = lottoTickets.countCorrectWinNumber(lottoMachine);
            List<Integer> bonusNumbers = lottoTickets.checkBonusNumber(lottoMachine);

            Analyzer analyzer = new Analyzer(totalPrice);
            analyzer.calculateTotalWinningMoney(integers, bonusNumbers);

            double profitPercent = analyzer.calculateProfitPercent();
            resultView.printAnalyzeResults(analyzer.getWinningPrices(), profitPercent);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
