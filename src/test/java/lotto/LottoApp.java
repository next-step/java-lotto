package lotto;

import lotto.UI.InputView;
import lotto.UI.ResultView;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.WinningNumbers;
import lotto.domain.purchaseStrategy.AutoPurchaseStrategy;

import java.util.List;

public class LottoApp {

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoApp app = new LottoApp();

        List<Lotto> lottos = app.buyLotto();;

        app.countLotto(lottos);

    }

    private List<Lotto> buyLotto() {
        int amount = inputView.EnterAmount();

        LottoShop lottoShop = new LottoShop();

        List<Lotto> lottos =  lottoShop.buyLotto(amount, new AutoPurchaseStrategy());

        resultView.printLottoCount(lottos);
        for(Lotto lotto : lottos) {
            resultView.printLottoNumbers(lotto);
        }

        return lottos;
    }

    private void countLotto(List<Lotto> lottos) {
        WinningNumbers winningNumbers = new WinningNumbers(inputView.EnterWinningNumbers());




    }


}
