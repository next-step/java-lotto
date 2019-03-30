import domain.*;
import util.Calculator;
import util.Console;
import util.Generator;
import view.InputView;
import view.ResultView;

import java.util.*;

public class LottoApplication {
    public static void main(String[] args) {
        try {
            Money money = new Money(InputView.inputMoney());
            int totalLottoPaper = money.calcPaper();
            int manualLottoPaper = InputView.buyManualLotto();
            money.checkPurchase(manualLottoPaper);
            int autoLottoPaper = totalLottoPaper - manualLottoPaper;

            List<Lotto> lottos = new ArrayList<>();
            while (manualLottoPaper-- > 0) {
                InputView.inputManualLottoNumbers();
                lottos.add(new Lotto(new LottoNumbers(InputView.scanLottoNumbers())));
            }

            ResultView.purchaseLottoCount(totalLottoPaper - autoLottoPaper, autoLottoPaper);
            while (autoLottoPaper-- > 0) {
                try {
                    Lotto lotto = new Lotto(new LottoNumbers(Generator.lottoNumbers()));
                    lottos.add(lotto);
                    ResultView.printLotto(lotto);
                } catch (Exception e) {
                    Console.print(e.getMessage());
                    return;
                }
            }

            InputView.inputWinningNumbers();
            WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(InputView.scanLottoNumbers()), InputView.inputBonusBall());

            Map<LottoRank, Integer> produceResult = new HashMap<>();
            for (Lotto lotto : lottos) {
                LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
                produceResult.put(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
            }

            ResultView.statisticsWinner(produceResult);
            ResultView.printYield(Calculator.yieldCalculator(produceResult, totalLottoPaper));
        } catch (InputMismatchException | NumberFormatException e) {
            Console.numberFormatExceptionMessage();
        } catch (Exception e) {
            Console.print(e.getMessage());
            return;
        }
    }
}