package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        int amount = InputView.inputAmount();

        NumberGenerator numberGenerator = new BasicNumberGenerator();
        LottoMachine lottoMachine = new BasicLottoMachine(numberGenerator);
        Store store = new Store(lottoMachine);
        User user = new User(amount);

        user.buyLottoIn(store);

        ResultView.printTotalLottoCount(user.countBoughtLotto());

        ResultView.printIssuedLottos(user.findIssuedLottos());

        String winNumbers = InputView.inputWinNumbers();

        user.checkLottoWin(winNumbers);

        ResultView.printWinStatus(
                user.countWinLotto(3),
                user.countWinLotto(4),
                user.countWinLotto(5),
                user.countWinLotto(6)
        );

        ResultView.printResult(user.calculateRate());
    }
}
