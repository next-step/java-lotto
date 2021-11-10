package lotto;

import lotto.domain.WinningRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.Lottos;
import lotto.vo.Money;
import lotto.vo.WinningHistory;

public class main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Money money = inputView.inputMoney();

        LottoService lottoService = new LottoService();

        Lottos lottos = lottoService.buyLotto(money);

        outputView.renderWithLottos(lottos);

        String winningLottoString = inputView.inputWinningLotto();

        WinningHistory winningHistory = lottoService.getWinningHistory(winningLottoString);

        outputView.renderWithWinningHistory(winningHistory, WinningRank.getReverseRankListWithoutNoRank());

    }
}
