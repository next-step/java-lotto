package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoTickets;
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

        LottoTickets lottoTickets = new LottoTickets(lottoCount);
        List<LottoDto> lottos = lottoTickets.generateTickets();
        ResultView.showAutoLottoTickets(lottos);

        Lotto lotto = new Lotto(InputView.askLastWeekWinningLottoNumbers());

        LottoWinning winning = lottoTickets.result(lotto);
        ResultView.printWinning(winning);
        ResultView.printWinningRate(winning, lottoAmount);
    }
}
