package lotto;

import lotto.domain.*;
import lotto.strategy.CreationAutoLottoNumber;
import lotto.strategy.CreationLottoNumber;
import lotto.strategy.CreationManualLottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop(InputView.requestPurchaseAmount(), InputView.requestManualRound());

        CreationLottoNumber manualLottoNumber = new CreationManualLottoNumber();
        Lottos manualLottos = Lottos.of(InputView.requestManualNumbers(lottoShop.getManualRound()), manualLottoNumber);

        ResultView.responseLottoCount(lottoShop.getManualRound(), lottoShop.getAutoRound());

        CreationLottoNumber autoLottoNumber = new CreationAutoLottoNumber();
        Lottos lottos = Lottos.of(lottoShop.getAutoRound(), autoLottoNumber, manualLottos);
        ResultView.responseLottoNumbers(lottos);

        PrizeLotto prizeLotto = new PrizeLotto(InputView.requestLastWeekWinningNumber(), InputView.requestBonusNumber());
        ResultView.responseStatistics(lottos.getResults(prizeLotto), lottoShop.getBuyAmount());
    }
}
