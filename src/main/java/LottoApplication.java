import domain.Lotto;
import domain.LottoGame;
import domain.UserLotto;
import domain.WinningLotto;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {
        UserLotto userLotto = new UserLotto();

        Long money = InputView.inputLottoPurchaseAmount();
        List<Lotto> lottoTickets = userLotto.generateRandomLottoTickets(money);

        ResultView.printLottoCount(lottoTickets.size());
        ResultView.printLottoNumbers(lottoTickets);

        LottoGame lottoGame = new LottoGame(userLotto);
        String inputWinningNumbers = InputView.inputWinningNumbers();
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers);

        Map<Integer, Integer> lottoPrizeIntegerMap = lottoGame.matchNumbers(winningLotto);
        ResultView.printLottoGameResult(lottoPrizeIntegerMap);

        float rate = lottoGame.calculateReturnRate(money, lottoPrizeIntegerMap);
        ResultView.printLottoReturnRate(rate);
    }
}
