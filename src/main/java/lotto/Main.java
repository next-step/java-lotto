package lotto;

import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int amount = InputView.readAmount();

        LottoTickets lottoTickets = LottoTicketMachine.issue(amount);
        ResultView.printLottoTickets(lottoTickets);

        List<Integer> winNumbers = InputView.readWinNumbers();
        Map<Integer, Integer> statisticsMap = lottoTickets.getLottoStatistics(winNumbers);

        ResultView.printLottoStatistics(statisticsMap);
    }

}
