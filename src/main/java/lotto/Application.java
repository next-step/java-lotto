package lotto;

import lotto.domain.*;
import lotto.domain.numbergenerator.ManualLottoNumbersGenerator;
import lotto.domain.numbergenerator.RandomLottoNumbersGenerator;
import lotto.exception.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.StringUtil.split;
import static lotto.view.Input.askBonusBall;
import static lotto.view.Input.askManualLottoCount;

public class Application {
    public static void main(String[] args) {
        Money money = getPurchaseAount();

        Money manualLottoMoney = money.manualLottoMoney(getManualLottoCount(money));
        int manualLottoCount = manualLottoMoney.lottoCount();

        List<Lotto> lottos = new ArrayList<>();

        while (manualLottoMoney.canBuy()) {
            manualLottoMoney.buy();

            Output.askManualLottosNumber();

            String manualLottosNumber = Input.askManualLottosNumber();
            String[] manualLottosNumbers = split(manualLottosNumber);

            List<LottoNumber> lottoNumbers = ManualLottoNumbersGenerator.from(manualLottosNumbers).generate();
            lottos.add(Lotto.from(lottoNumbers));
        }

        Money autoLottoMoney = money.autoLottoMoney(manualLottoCount);

        Lottos manualLottos = Lottos.from(lottos);
        Lottos autoLottos = LottosFactory.from(autoLottoMoney, new RandomLottoNumbersGenerator());

        manualLottos.merge(autoLottos);

        Output.printLottosCount(manualLottoCount, autoLottoMoney.lottoCount());
        Output.printLottos(manualLottos);

        String askWinningNumbers = Input.askWinningNumber();
        String[] winningNumbers = split(askWinningNumbers);

        LottoNumber bonusBall = getBonusBall();

        WinningLotto winningLotto = getWinningNumber(winningNumbers, bonusBall);

        WinningStatistics statistics = WinningStatistics.from(manualLottos, winningLotto);
        Output.printWinningStatistics(statistics);
    }

    private static int getManualLottoCount(Money purchaseAmount) {
        int manualLottoCount = askManualLottoCount();

        return purchaseAmount.validateManualLottoCount(manualLottoCount);
    }

    private static LottoNumber getBonusBall() {
        int bonusBall = askBonusBall();
        try {
            return LottoNumber.from(bonusBall);
        } catch (LottoNumberException e) {
            Output.lottoNumberError();
            return getBonusBall();
        }
    }

    private static Money getPurchaseAount() {
        int purchaseAmount = Input.askPurchaseAmount();
        try {
            return Money.from(purchaseAmount);
        } catch (MinimumAmountException e) {
            Output.printMoneyError();
            return getPurchaseAount();
        }
    }

    private static WinningLotto getWinningNumber(String[] winningNumber, LottoNumber bonusBall) {
        try {
            return WinningLotto.from(winningNumber, bonusBall);
        } catch (LottoNumberException e) {
            Output.lottoNumberError();

            return getWinningNumber(winningNumber, bonusBall);
        } catch (LottoNumbersCountException e) {
            String winningNumberInput = Input.askWinningNumber();
            String[] split = split(winningNumberInput);

            Output.winningNumberCountError();

            return getWinningNumber(split, bonusBall);
        } catch (BonusNumberException e) {
            Output.bonusNumberError();

            return getWinningNumber(winningNumber, getBonusBall());
        }
    }
}
