package lotto;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.service.NumberGenerateStrategy;
import lotto.service.RandomLottoNumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.*;

public class main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = getLottoService();

        Money money = inputView.inputMoney();

        Wallet wallet = buyLotto(money, lottoService);

        outputView.renderWithLottos(wallet.getLottos());

        WinningHistory winningHistory = startLottoService(inputView, lottoService, wallet);

        outputView.renderWithWinningHistory(winningHistory, WinningRank.getReverseRankListWithoutNoRank());

    }

    private static WinningHistory startLottoService(InputView inputView, LottoService lottoService, Wallet wallet) {
        Lotto winningLotto = getWinningLotto(inputView);

        LottoNumber lottoNumber = getBonusBall(inputView);

        lottoService.validBonus(winningLotto, lottoNumber);

        WinningHistory winningHistory = lottoService.getWinningHistory(winningLotto, lottoNumber, wallet);
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

    private static Wallet buyLotto(Money money, LottoService lottoService) {
        return Wallet.create(money,lottoService.buyLotto(money));
    }

    private static LottoService getLottoService() {
        NumberGenerateStrategy strategy = new RandomLottoNumberGenerateStrategy();
        LottoGenerator lottoGenerator = LottoGenerator.create(strategy);
        LottoSeller lottoSeller = LottoSeller.create(Money.create(LottoRule.LOTTO_PRICE.getValue()), lottoGenerator);
        LottoService lottoService = new LottoService(lottoSeller);
        return lottoService;
    }
}
