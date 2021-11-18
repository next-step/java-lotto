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

        LottoService lottoService = getLottoService(inputView);

        buyLotto(outputView, lottoService);

        WinningHistory winningHistory = startLottoService(inputView, lottoService);

        outputView.renderWithWinningHistory(winningHistory, WinningRank.getReverseRankListWithoutNoRank());

    }

    private static WinningHistory startLottoService(InputView inputView, LottoService lottoService) {
        Lotto winningLotto = getWinningLotto(inputView);

        LottoNumber lottoNumber = getBonusBall(inputView);

        lottoService.validBonus(winningLotto, lottoNumber);

        WinningHistory winningHistory = lottoService.getWinningHistory(winningLotto, lottoNumber);
        return winningHistory;
    }

    private static LottoNumber getBonusBall(InputView inputView) {
        String bonusBallString = inputView.inputBonus();

        LottoNumber lottoNumber = LottoNumber.create(bonusBallString);
        return lottoNumber;
    }

    private static Lotto getWinningLotto(InputView inputView) {
        String winningLottoString = inputView.inputWinningLotto();

        Lotto winningLotto = Lotto.create(winningLottoString);
        return winningLotto;
    }

    private static void buyLotto(OutputView outputView, LottoService lottoService) {
        Lottos lottos = lottoService.buyLotto();

        outputView.renderWithLottos(lottos);
    }

    private static LottoService getLottoService(InputView inputView) {
        Money money = inputView.inputMoney();

        NumberGenerateStrategy strategy = new RandomLottoNumberGenerateStrategy();
        LottoService lottoService = new LottoService(money, strategy);
        return lottoService;
    }
}
