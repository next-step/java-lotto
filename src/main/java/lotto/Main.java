package lotto;

import lotto.domain.Generator;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    private static final Generator generator = new Generator();

    public static void main(String[] args) {
        Lottos lottos = purchageLottos();
        Lotto winningNumbers = inputWinningNumbers();
        printReport(lottos, winningNumbers);
    }

    private static Lottos purchageLottos() {
        int inputPrice = InputView.purchase();
        Lottos lottos = generator.run(inputPrice);
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
