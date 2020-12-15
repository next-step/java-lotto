package lotto;

import lotto.domain.LottoGame;
import lotto.domain.MatchResult;
import lotto.domain.RandomTicketMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMain {

    public static void main(String[] args) {
        int money = InputView.money();
        LottoGame lottoGame = new LottoGame(money, new RandomTicketMachine());
        OutputView.printTickets(lottoGame.getLottoTickets());

        String winningNumbers = InputView.lastWinningNumbers();
        String bonusNumber = InputView.bonusNumber();
        MatchResult matchResult = lottoGame.match(winningNumbers, bonusNumber);

        OutputView.printResults(matchResult);
    }
}
