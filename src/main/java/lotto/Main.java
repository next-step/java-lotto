package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final int amount = InputView.inputAmount();

        NumberGenerator numberGenerator = new BasicNumberGenerator();
        LottoMachine lottoMachine = new BasicLottoMachine(numberGenerator);
        Store store = new Store(lottoMachine);
        User user = new User(amount);

        final int directCount = InputView.inputDirectCount();
        final List<String> directLottoNumbers = InputView.inputDirectLottoNumbers(directCount);

        user.buyLotto(store, directLottoNumbers);

        ResultView.printTotalLottoCount(user.getCountOfDirectLottos(), user.getCountOfAutoLottos());

        ResultView.printIssuedLottos(user.findIssuedLottos());

        String winNumbers = InputView.inputWinNumbers();
        String bonusNumber = InputView.inputBonusNumber();

        WinningStatus winningStatus = user.checkLottoRank(winNumbers, bonusNumber);

        ResultView.printWinningStatus(winningStatus);

        ResultView.printResult(user.calculateRate(winningStatus.getTotalWinningAmount()));
    }
}
