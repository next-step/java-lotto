package lotto;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        Lottos lottos = purchageLottos();
        Lotto winningNumbers = inputWinningNumbers();
        printReport(lottos, winningNumbers);
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

    private static void printReport(Lottos lottos, Lotto winningNumbers) {
        ResultView.printReport(lottos, winningNumbers);
    }
}
