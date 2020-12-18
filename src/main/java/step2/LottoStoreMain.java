package step2;

import step2.domain.Request;
import step2.domain.lotto.Lotto;
import step2.view.InputView;

import java.util.List;

import static step2.view.ResultView.*;

public class LottoStoreMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Request request = inputView.putPurchaseMoney();

        Lotto lotto = new Lotto(request);
        printLotto(lotto.getLotto(), ", ");

        List<Integer> targetNumber = inputView.putTargetNumber();
        printWinLotto(lotto, targetNumber, inputView.putBonusNumber(targetNumber), request);
    }
}
