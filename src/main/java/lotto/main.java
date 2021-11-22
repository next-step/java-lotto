package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.*;

public class main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoSeller lottoSeller = LottoSeller.create(Money.create(LottoRule.LOTTO_PRICE.getValue()));
        Money originMoney = inputView.inputMoney();
        Wallet wallet = Wallet.create(originMoney);

        wallet = buyLotto(wallet, lottoSeller);

        outputView.renderWithLottos(wallet.getLottos());

        WinningHistory winningHistory = startLottoService(inputView, wallet);

        outputView.renderWithWinningHistory(winningHistory, WinningRank.getReverseRankListWithoutNoRank());

    }

    private static WinningHistory startLottoService(InputView inputView, Wallet wallet) {
        Lotto winningLotto = getWinningLotto(inputView);

        LottoNumber lottoNumber = getBonusBall(inputView);

        winningLotto.validBonus(lottoNumber);

        return wallet.getWinningHistory(winningLotto, lottoNumber);
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

    private static Wallet buyLotto(Wallet wallet, LottoSeller lottoSeller) {
        Lottos lottos = lottoSeller.buyLottos(wallet.getAllMoney(), new RandomLottoGenerator());
        return wallet.saveLottos(lottos);
    }

}
