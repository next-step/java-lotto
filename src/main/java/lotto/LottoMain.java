package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.requestPurchaseAmount();
        int ticketNumber = amount / 1000;

        LottoGame lottoGame = new LottoGame();
        Lottos lottos = lottoGame.purchase(ticketNumber);

        ResultView.printPurchaseLottos(lottos);
        lottoGame.drawLotto(getWinnerLottoNumbers());

        ResultView.printWinners(lottoGame);
        ResultView.printYield(lottoGame, amount);
    }

    private static Set<LottoNumber> getWinnerLottoNumbers() {
        Set<Integer> winnerNumbers = InputView.requestWinnerNumbers();
        return winnerNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
