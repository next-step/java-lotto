package step3;

import step3.domian.LastWinner;
import step3.domian.LottoWallet;
import step3.domian.Revenue;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

import static step3.domian.LottoMachine.autoLottos;

public class LottoMain {
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int lottoNum = InputView.buyLotto() / LOTTO_PRICE;
        ResultView.printLottoCount(lottoNum);

        LottoWallet lottoWallet = autoLottos(lottoNum);
        ResultView.printLottoNum(lottoWallet);

        LastWinner lastWinner = new LastWinner(InputView.inputLastWinner(), InputView.inputLastBonus());
        List<Integer> results = lottoWallet.compareWithLastLotto(lastWinner);
        ResultView.printDrawResult(results);

        Revenue revenue = new Revenue(results);
        ResultView.printPercentage(revenue.calculatePercentage(lottoNum * LOTTO_PRICE));
    }
}
