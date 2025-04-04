package lotto;


import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.ManualStrategy;
import lotto.domain.Seller;
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

        String inputWinLotto = InputView.inputWinLotto();
        String bonusNumber = InputView.inputBonusLottoNumber();

        WinningLotto winLotto =
                new WinningLotto(new ManualStrategy(inputWinLotto).generate(), new LottoNumber(bonusNumber));
        LottoGame lottoGame = new LottoGame(lottos, winLotto);
        OutputView.printStatics(lottoGame.getRanks(), lottoGame.getProfit());
    }
}
