package step2;

import step2.domain.LottoRequest;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.LottoNumbers;
import step2.view.InputView;

import static step2.view.ResultView.*;

public class LottoStoreMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoRequest lottoRequest = new LottoRequest(inputView.putPurchaseMoney(), inputView.putLottoNumbersForManualPick());

        Lotto lotto = new Lotto(lottoRequest);
        printLotto(lotto.getLotto(), ", ", lottoRequest);

        LottoNumbers targetLottoNumbers = inputView.putTargetLottoNumbers();
        LottoNumber bonusNumber = inputView.putBonusNumber(targetLottoNumbers);
        printWinLotto(lotto.getWinLotto(targetLottoNumbers, bonusNumber), lottoRequest);
    }
}
