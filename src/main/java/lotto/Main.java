package lotto;

import lotto.domain.Generator;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    private static final Generator generator = new Generator();

    public static void main(String[] args) {
        List<Lotto> lottos = purchageLottos();
        Lotto winningNumbers = inputWinningNumbers();
    }

    private static List<Lotto> purchageLottos() {
        int inputPrice = InputView.purchase();
        List<Lotto> lottos = generator.run(inputPrice);
        ResultView.printLottos(lottos);
        return lottos;
    }

    private static Lotto inputWinningNumbers() {
        return InputView.winningNumbers();
    }
}
