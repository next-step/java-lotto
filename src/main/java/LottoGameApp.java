import domain.LottoGames;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGameApp {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        List<Integer> winningNumberStr = InputView.getWinningNumberStr();
        LottoGames lottoGames = LottoGames.of(money, winningNumberStr);

        OutputView.printLottoGames(lottoGames.getLottoGames());

        Map<Integer, Integer> gameStatistics = OutputView.printWinningInfo(lottoGames);
        OutputView.printBenefitRate(lottoGames, gameStatistics);
    }
}
