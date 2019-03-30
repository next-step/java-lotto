import domain.*;
import domain.generator.AutoLotto;
import domain.generator.ManualLotto;
import util.Console;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        try {
            Money money = new Money(InputView.inputMoney());
            int manualLottoPaper = InputView.buyManualLotto();

            List<Lotto> lottos = new ArrayList<>();

            for (int i = 0; i < manualLottoPaper; i++) {
                InputView.inputManualLottoNumbers();
                lottos.add(new ManualLotto(InputView.scanLottoNumbers()).generate());
            }

            ResultView.purchaseLottoCount(manualLottoPaper, money.calcBalance(manualLottoPaper));

            for (int i = 0; i < money.calcBalance(manualLottoPaper); i++) {
                Lotto lotto = new AutoLotto().generate();
                ResultView.printLotto(lotto);
                lottos.add(lotto);
            }

            InputView.inputWinningNumbers();
            WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(InputView.scanLottoNumbers()), new LottoNo(InputView.inputBonusBall()));

            LottoResult lottoResult = new LottoResult(lottos, winningNumbers);
            ResultView.statisticsWinner(lottoResult);
            ResultView.printYield(new Profit(lottoResult).calcProfile(money.calcPaper()));
        } catch (InputMismatchException | NumberFormatException e) {
            Console.numberFormatExceptionMessage();
        } catch (Exception e) {
            Console.print(e.getMessage());
            return;
        }
    }
}