import domain.Number;
import domain.*;
import view.InputView;
import view.OutputView;

import java.util.Set;

public class LottoGameApp {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        LottoMoney lottoMoney = new LottoMoney(money);
        LottoGame lottoGame = LottoGame.of(money);
        OutputView.printLottoGames(lottoGame.getLottoNumbersList());
        Set<Number> winningNumber = InputView.getWinningNumber();
        LottoNumbers lottoNumbers = new LottoNumbers(winningNumber);

        WinningInfos winningInfos = OutputView.printWinningInfo(lottoGame, lottoNumbers);
        OutputView.printBenefitRate(lottoGame, lottoMoney, winningInfos);
    }
}
