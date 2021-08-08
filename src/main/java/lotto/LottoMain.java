package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.strategy.ListMixStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.requestPurchaseAmount();
        int ticketNumber = amount / 1000;

        LottoGame lottoGame = new LottoGame();
        lottoGame.purchase(ticketNumber);

        lottoGame.drawLotto(getWinnerLottoNumbers());

        ResultView.printWinners(lottoGame);
        ResultView.printYield(lottoGame, amount);
    }

    private static LottoNumbers getWinnerLottoNumbers() {
        List<Integer> winnerNumbers = InputView.requestWinnerNumbers();
        List<LottoNumber> winnerLottoNumberList = winnerNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(winnerLottoNumberList);
    }
}
