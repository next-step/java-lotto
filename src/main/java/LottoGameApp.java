import domain.LottoGame;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoGameApp {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        List<Integer> winningNumberStr = InputView.getWinningNumberStr();
        LottoGame lottoGame = LottoGame.of(money, winningNumberStr);

        OutputView.printLottoGames(lottoGame.getLottoNumbersList());

        OutputView.printWinningInfo(lottoGame);
        OutputView.printBenefitRate(lottoGame);
    }
}
