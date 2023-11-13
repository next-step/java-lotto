package src;

import src.domain.GameNumber;
import src.domain.Lotto;
import src.domain.LottoGameNumberGenerator;
import src.domain.LottoMachine;
import src.domain.Lottos;
import src.domain.MatchStatus;
import src.domain.Money;
import src.view.InputView;
import src.view.ResultView;

import java.util.HashSet;
import java.util.Set;

public class LottoGameController {

    public static void main(String[] args) {
        Money money = new Money(InputView.inputPurchasePrice());

        LottoMachine lottoMachine = new LottoMachine(new LottoGameNumberGenerator());
        Lottos lottos = lottoMachine.buyLottos(money);
        printLottos(lottos);

        Lotto winningLotto = inputWinningLotto();

        MatchStatus matchStatus = lottos.match(winningLotto);
        double profitRate = matchStatus.profitRate(Lotto.PRICE_OF_LOTTO);
        ResultView.printMatchResult(matchStatus, profitRate);


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
