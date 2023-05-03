package lotto;

import lotto.domain.*;
import lotto.utils.LottoIssuer;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        long purchasePrice = inputView.inputPurchasePrice();
        long lottoCount = LottoGame.lottoCount(purchasePrice);

        ResultView.printLottoCount(lottoCount);

        List<Lotto> lottos = LottoIssuer.issueLottos(lottoCount);

        ResultView.printLottos(lottos);

        Lotto winningLotto = LottoGame.winningLotto(inputView.inputWinningLotto());
        LottoNumber bonusLottoNumber = LottoGame.bonusLottoNumber(inputView.inputBonusLottoNumber(winningLotto));

        LottoRewards lottoRewards = LottoGame.reward(lottos, winningLotto(winningLotto, bonusLottoNumber));
        double totalProfitRate = LottoGame.totalProfitRate(lottoRewards, purchasePrice);

        ResultView.printWinningStatics(lottoRewards, totalProfitRate);

        inputView.close();
    }

    private static WinningLotto winningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        return new WinningLotto(winningLotto, bonusLottoNumber);
    }
}
