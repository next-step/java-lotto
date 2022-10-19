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
        InputView.askAmount();
        LottoAmount lottoAmount = new LottoAmount(InputView.inputAnswer());
        int lottoCount = lottoAmount.calcLottoCount();
        ResultView.showLottoCount(lottoCount);

        LottoTickets lottoTickets = new LottoTickets(lottoCount);
        List<LottoDto> lottos = lottoTickets.generateTickets();
        ResultView.showAutoLottoTickets(lottos);

        InputView.askLastWeekWinningLottoNumbers();
        Lotto lotto = new Lotto(InputView.inputAnswer());

        LottoWinning winning = lottoTickets.result(lotto);
        ResultView.printWinning(winning);
        ResultView.printWinningRate(winning, lottoAmount);
    }
}
