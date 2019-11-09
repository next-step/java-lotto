package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final int money = InputView.inputMoney();
        final User user = new User(money);

        final int directCount = InputView.inputDirectCount();
        final List<String> directLottos = InputView.inputDirectLottoNumbers(directCount);

        final LottoMachine lottoMachine = new BasicLottoMachine();
        final Store store = new Store(lottoMachine);
        user.buyLottosIn(store, directLottos);

        ResultView.printLottoCount(user.findCountOfDirectLottos(), user.findCountOfAutoLottos());
        ResultView.printLottos(user.findLottos());

        final String winNumbers = InputView.inputWinNumbers();
        final int bonusNumber = InputView.inputBonusNumber();
        final WinningLottos winningLottos = user.checkLottos(winNumbers, bonusNumber);

        ResultView.printWinningStatus(winningLottos);
        ResultView.printResult(winningLottos.getRate(money));
    }
}
