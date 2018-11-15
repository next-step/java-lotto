import domain.*;
import domain.lottosGenerator.AutoLottosGenerator;
import domain.lottosGenerator.ManualLottosGenerator;
import domain.winningStatus.WinningStatus;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Money amount = new Money(InputView.inputPurchaseAmount());

        int manualGameCount = InputView.inputManualGameCount();
        List<String> manualGameNumbers = InputView.inputManualGameNumbers(manualGameCount);

        LottoMachine lottoMachine = new LottoMachine();

        List<Lotto> manualGames = lottoMachine.purchaseLotto(amount, new ManualLottosGenerator(manualGameNumbers));

        Money autoMoney = amount.remain(manualGames.size());
        List<Lotto> autoGames = lottoMachine.purchaseLotto(autoMoney, new AutoLottosGenerator());

        manualGames.addAll(autoGames);

        LottoGames lottoGames = new LottoGames();
        manualGames.forEach(lottoGames::add);

        ResultView.purchasedLottoGamesCount(manualGames.size(), autoGames.size());
        ResultView.purchasedLottoGames(lottoGames);

        String winningNumbers = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());

        WinningNumber winningNumber = new WinningNumber(Lotto.fromCommaString(winningNumbers), bonusNumber);

        WinningStatus status = lottoGames.match(winningNumber);
        ResultView.lottoResult(status);
    }
}
