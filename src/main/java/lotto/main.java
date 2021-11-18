package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;
import lotto.service.LottoService;
import lotto.service.NumberGenerateStrategy;
import lotto.service.RandomLottoNumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.LottoNumber;
import lotto.vo.Lottos;
import lotto.vo.Money;
import lotto.vo.WinningHistory;

public class main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Money money = inputView.inputMoney();

        NumberGenerateStrategy strategy = new RandomLottoNumberGenerateStrategy();
        LottoService lottoService = new LottoService(money, strategy);

        Lottos lottos = lottoService.buyLotto();

        outputView.renderWithLottos(lottos);

        String winningLottoString = inputView.inputWinningLotto();

        Lotto winningLotto = Lotto.create(winningLottoString);

        String bonusBallString = inputView.inputBonus();

        LottoNumber lottoNumber = LottoNumber.create(bonusBallString);

        lottoService.validBonus(winningLotto, lottoNumber);

        WinningHistory winningHistory = lottoService.getWinningHistory(winningLotto, lottoNumber);

        outputView.renderWithWinningHistory(winningHistory, WinningRank.getReverseRankListWithoutNoRank());

    }
}
