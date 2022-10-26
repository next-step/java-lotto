package step4;

import step4.domain.LastWinner;
import step4.domain.LottoResult;
import step4.domain.LottoWallet;
import step4.domain.Revenue;
import step4.view.InputView;
import step4.view.ResultView;;

import static step4.domain.LottoMachine.autoLottos;

public class LottoMain {
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int lottoNum = InputView.buyLotto() / LOTTO_PRICE;
        int manualNum = InputView.inputManualNum();
        int autoNum = lottoNum - manualNum;

        LottoWallet lottoWallet = new LottoWallet(InputView.inputManualLottos(manualNum), autoLottos(autoNum));
        ResultView.printLottoNum(manualNum, autoNum, lottoWallet);

        LastWinner lastWinner = new LastWinner(InputView.inputLastWinner(), InputView.inputLastBonus());
        LottoResult results = lottoWallet.compareWithLastLotto(lastWinner);
        ResultView.printDrawResult(results);

        Revenue revenue = new Revenue(results);
        ResultView.printPercentage(revenue.calculatePercentage(lottoNum * LOTTO_PRICE));
    }
}
