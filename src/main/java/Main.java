import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.WinnerLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = InputView.enterInput();

        LottoStore lottoStore = new LottoStore(inputView.getMoney());
        List<Lotto> lottos = lottoStore.sellLotto();
        WinnerLotto winnerLotto = new WinnerLotto(lottos);

        ResultView.printLottoResult(winnerLotto.getPrize(winnerLotto.enterWinningNumbers()));
    }
}
