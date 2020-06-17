import lotto.domain.LottoTicket;
import lotto.domain.LottoStore;
import lotto.domain.WinnerLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = InputView.enterInput();

        LottoStore lottoStore = new LottoStore(inputView.getLottoMoney());
        List<LottoTicket> lottoTickets = lottoStore.sellLottoTicket();
        WinnerLotto winnerLotto = new WinnerLotto(lottoTickets);

        ResultView.printLottoResult(winnerLotto.getPrize(winnerLotto.enterWinningNumbers()));
    }
}
