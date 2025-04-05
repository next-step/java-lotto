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
        int manualLottoCount = InputView.inputManualLotto();
        Seller seller = new Seller(inputValue, manualLottoCount);

        seller.generateManual(InputView.inputLotto(manualLottoCount));
        List<Lotto> lottos = seller.generateAuto();
        OutputView.printLottos(lottos);

        String inputWinLotto = InputView.inputWinLotto();
        String bonusNumber = InputView.inputBonusLottoNumber();

        WinningLotto winLotto =
                new WinningLotto(new ManualStrategy(inputWinLotto).generate(), new LottoNumber(bonusNumber));
        LottoGame lottoGame = new LottoGame(lottos, winLotto);
        OutputView.printStatics(lottoGame.getRanks(), lottoGame.getProfit());
    }
}
