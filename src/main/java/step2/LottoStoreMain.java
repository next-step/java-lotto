package step2;

import step2.domain.LottoRequest;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.LottoNumbers;
import step2.view.InputView;

import java.util.List;

import static step2.view.ResultView.*;

public class LottoStoreMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoRequest lottoRequest = inputView.putPurchaseMoney();

        Lotto lotto = new Lotto(lottoRequest);
        printLotto(lotto.getLotto(), ", ");

        List<Integer> targetNumber = inputView.putTargetNumber();
        Integer bonusNumber = inputView.putBonusNumber(targetNumber);
        printWinLotto(lotto.getWinLotto(new LottoNumbers(targetNumber), new LottoNumber(bonusNumber)), lottoRequest);
    }
}
