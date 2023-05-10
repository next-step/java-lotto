package lotto;

import lotto.biz.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApp {

    public static void main(String[] args) {
        LottoService service = new LottoService();
        service.setPurchaseValue(InputView.setSaleAmount());

        ResultView.showAllTickets(service.getGames());

        service.setWinningNumbers(InputView.setWinningNumbers());
        service.setBonusNumber(InputView.setBonusNumber());
        service.aggregateWinningStatistics();

        ResultView.showWinningStatistics(service.getStatistic());
        ResultView.showProfit(service.getStatistic(),service.getPurchaseValue());

    }
}
