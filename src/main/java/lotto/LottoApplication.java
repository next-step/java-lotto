package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int lottoCount = InputView.calculateLottoCount();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<LottoTicket> lottoTickets = lottoGenerator.generate(lottoCount);

        ResultView.showLottoTickets(lottoTickets);
    }
}
