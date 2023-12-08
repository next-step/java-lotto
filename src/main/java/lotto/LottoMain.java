package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int number = InputView.priceView();
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.generateLottoTicket(number);
        ResultView.lottoTicketView(lottoTicket);
        Lotto winningLotto = InputView.winningLottoView();
        int bonusNo = InputView.bonusNumberView();
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoTicket.match(lottoMachine, winningLotto, lottoStatistics, bonusNo);
        ResultView.statisticsView(lottoStatistics, number);
    }
}
