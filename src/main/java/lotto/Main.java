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

        ResultView.printTotalLottoCount(user.getCountOfLottos());

        ResultView.printIssuedLottos(user.findIssuedLottos());

        String winNumbers = InputView.inputWinNumbers();
        String bonusNumber = InputView.inputBonusNumber();

        user.checkLottoRank(winNumbers, bonusNumber);

        ResultView.printWinningStatus(user.getWinningStatus());

        ResultView.printResult(user.calculateRate());
    }
}
