package lotto;


import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.ManualStrategy;
import lotto.domain.Seller;
import lotto.domain.WinnerChecker;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        int inputValue = InputView.inputMoney();
        List<String> manualLotto = InputView.inputManualLotto();

        Seller seller = new Seller(inputValue, manualLotto);
        List<Lotto> lottos = seller.generateLottos();
        OutputView.printLottos(lottos);

        String enteredWinningNumbers = InputView.inputWinLotto();
        Lotto winningLotto = new ManualStrategy(enteredWinningNumbers).generate();

        String bonusLottoNumber = InputView.inputBonusLottoNumber();
        LottoNumber bonusNumber = new LottoNumber(bonusLottoNumber);

        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(lottos, winningLotto, bonusNumber);
        OutputView.printStatics(lottoWinningChecker.getRanks(), lottoWinningChecker.getProfitRate());

    }
}
