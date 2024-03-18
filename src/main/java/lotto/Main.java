package lotto;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int purchaseAmount = InputView.readAmount();

        LottoTickets lottoTickets = LottoTicketMachine.issue(purchaseAmount);
        ResultView.printLottoTickets(lottoTickets);

        List<Integer> winNumbers = InputView.readWinNumbers();
        Map<Integer, Integer> statisticsMap = LottoStatistics.getLottoStatisticsMap(lottoTickets, winNumbers);

        ResultView.printLottoStatistics(statisticsMap, purchaseAmount);
    }

}
