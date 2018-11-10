import domain.Lotto;
import domain.LottoMachine;
import domain.WinningNumber;
import domain.WinningStatus;
import util.ParsingUtil;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int amount = InputView.inputPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottoGames = lottoMachine.purchaseLotto(amount);

        ResultView.purchasedLottoGames(lottoGames);

        String numbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        WinningNumber winningNumber = new WinningNumber(
            ParsingUtil.parseStringToIntList(numbers), bonusNumber);

        WinningStatus status = lottoMachine.match(lottoGames, winningNumber);
        ResultView.lottoResult(status);
    }
}
