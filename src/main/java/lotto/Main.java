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

        Lotto winningLottoExcludeBonus = inputView.inputWinningLotto();
        LottoNumber bonusLottoNumber = inputView.inputBonusLottoNumber(winningLottoExcludeBonus);
        WinningLotto winningLotto = new WinningLotto(winningLottoExcludeBonus, bonusLottoNumber);

        LottoRewards lottoRewards = LottoGame.reward(lottos, winningLotto);
        double totalProfitRate = LottoGame.totalProfitRate(lottoRewards, purchasePrice);

        ResultView.printWinningStatics(lottoRewards, totalProfitRate);

        inputView.close();
    }

}
