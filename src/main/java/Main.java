import domain.*;
import util.ParsingUtil;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Money amount = new Money(InputView.inputPurchaseAmount());

        int manualGameCount = InputView.inputManualGameCount();
        List<String> manualGameNumbers = InputView.inputManualGameNumbers(manualGameCount);

        LottoMachine lottoMachine = new LottoMachine();
        LottoGames lottoGames = lottoMachine.purchaseLotto(amount, manualGameNumbers);

        ResultView.purchasedLottoGames(lottoGames);

        String numbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        WinningNumber winningNumber = new WinningNumber(
            ParsingUtil.parseStringToIntList(numbers), bonusNumber);

        WinningStatus status = lottoMachine.match(lottoGames, winningNumber);
        ResultView.lottoResult(status);
    }
}
