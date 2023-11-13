package src;

import src.domain.GameNumber;
import src.domain.Lotto;
import src.domain.LottoGameNumberGenerator;
import src.domain.LottoMachine;
import src.domain.Lottos;
import src.domain.Money;
import src.domain.Place;
import src.view.InputView;
import src.view.ResultView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGameController {

    public static void main(String[] args) {
        Money money = new Money(InputView.inputPurchasePrice());

        LottoMachine lottoMachine = new LottoMachine(new LottoGameNumberGenerator());
        Lottos lottos = lottoMachine.buyLottos(money);
        printLottos(lottos);

        Lotto winningLotto = inputWinningLotto();

        List<Place> match = lottos.match(winningLotto);

    }

    private static void printLottos(Lottos lottos) {
        ResultView.printPurchaseLottoGameCount(lottos.size());
        ResultView.printLottos(lottos);
    }

    private static Lotto inputWinningLotto() {
        Set<GameNumber> winningNumbers = new HashSet<>(6);

        for (Integer number: InputView.inputWinningNumbers()) {
            winningNumbers.add(GameNumber.of(number));
        }

        return new Lotto(winningNumbers);
    }
}
