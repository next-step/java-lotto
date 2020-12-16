package lotto;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoUserRequest;
import lotto.domain.MatchResult;
import lotto.domain.machine.ComplexTicketMachine;
import lotto.domain.machine.RandomTicketMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMain {

    public static void main(String[] args) {
        int money = InputView.money();
        List<String> manualNumbers = InputView.manualNumbers();
        LottoUserRequest lottoUserRequest = new LottoUserRequest(money, manualNumbers);
        LottoGame lottoGame = new LottoGame(lottoUserRequest, new ComplexTicketMachine());
        OutputView.printTickets(lottoUserRequest, lottoGame.getLottoTickets());

        String winningNumbers = InputView.lastWinningNumbers();
        String bonusNumber = InputView.bonusNumber();
        MatchResult matchResult = lottoGame.match(winningNumbers, bonusNumber);

        OutputView.printResults(matchResult);
    }
}
