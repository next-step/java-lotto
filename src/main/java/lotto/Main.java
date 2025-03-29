package lotto;

import java.util.List;
import java.util.Scanner;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.WinningLotto;
import lotto.domain.LottoChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int money = inputView.inputPurchaseAmount();

        LottoMachine machine = new LottoMachine(money);
        List<Lotto> lottos = machine.getLottos();
        OutputView.printLottoCount(lottos.size());
        OutputView.printLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumbers());
        LottoChecker checker = new LottoChecker(winningLotto);
        OutputView.printWinningStatistics(money, checker.check(lottos));
    }
}
