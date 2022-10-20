package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinning;
import lotto.dto.LottoDto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoAmount lottoAmount = new LottoAmount(InputView.askAmount());
        int lottoCount = lottoAmount.calcLottoCount();
        ResultView.showLottoCount(lottoCount);

        LottoTicket lottoTicket = new LottoTicket(lottoCount);
        List<LottoDto> lottos = lottoTicket.generateTickets();
        ResultView.showAutoLottoTicket(lottos);

        Lotto winningLotto = new Lotto(InputView.askWinningLottoNumbers());

        LottoWinning winning = lottoTicket.result(winningLotto);
        ResultView.printWinning(winning);
        ResultView.printWinningRate(winning, lottoAmount);
    }
}
