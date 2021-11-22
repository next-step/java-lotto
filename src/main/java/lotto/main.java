package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import lotto.domain.Wallet;
import lotto.domain.WinningRank;
import lotto.dto.LottoInput;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.LottoNumber;
import lotto.vo.LottoRule;
import lotto.vo.Money;
import lotto.vo.WinningHistory;

public class main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoInput lottoInput = inputView.getLottoInput();

        Wallet wallet = buyLottos(lottoInput);

        outputView.renderWithLottos(wallet.getLottos(), lottoInput);

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

    private static Wallet buyLottos(LottoInput lottoInput) {
        Wallet wallet = Wallet.create(lottoInput.getMoney());
        LottoSeller lottoSeller = LottoSeller.create(Money.create(LottoRule.LOTTO_PRICE.getValue()));

        return wallet.buyLottos(lottoSeller, lottoInput);
    }

}
