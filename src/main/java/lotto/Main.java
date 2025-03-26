package lotto;

import java.util.Scanner;

import lotto.domain.LottoChecker;
import lotto.domain.LottoMachine;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int money = inputView.inputPurchaseAmount();

        LottoMachine machine = new LottoMachine(money);
        OutputView.printLottoCount(machine.getLottos().size());
        OutputView.printLottos(machine.getLottos());

        WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumbers());
        LottoChecker checker = new LottoChecker(winningLotto);
        OutputView.printWinningStatistics(money, checker.check(machine.getLottos()));
    }
}
