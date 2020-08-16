import domain.LottoGame;
import domain.LottoMoney;
import domain.Number;
import domain.WinningInfos;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoGameApp {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        LottoMoney lottoMoney = new LottoMoney(money);
        List<Number> winningNumber = InputView.getWinningNumber();
        LottoGame lottoGame = LottoGame.of(money, winningNumber);


        OutputView.printLottoGames(lottoGame.getLottoNumbersList());

        WinningInfos winningInfos = OutputView.printWinningInfo(lottoGame);
        OutputView.printBenefitRate(lottoGame, lottoMoney, winningInfos);
    }
}
