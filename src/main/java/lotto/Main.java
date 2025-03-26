package lotto;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        Lottos lottos = purchageLottos();
        Lotto winningNumbers = inputWinningNumbers();
        Number bonusNumber = inputBonusNumber();
        printReport(lottos, winningNumbers, bonusNumber);
    }

    private static Lottos purchageLottos() {
        Amount amount = InputView.purchase();
        Lottos lottos = Lottos.from(amount);
        ResultView.printLottos(lottos);
        return lottos;
    }

    private static Lotto inputWinningNumbers() {
        return InputView.winningNumbers();
    }

    private static Number inputBonusNumber() {
        return InputView.BonusNumber();
    }

    private static void printReport(Lottos lottos, Lotto winningNumbers, Number bonusNumber) {
        ResultView.printReport(lottos, winningNumbers, bonusNumber);
    }
}
