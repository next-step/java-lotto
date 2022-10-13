package step2;

import step2.domian.LastWinner;
import step2.domian.LottoWallet;
import step2.domian.Revenue;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

import static step2.domian.LottoMachine.autoLottos;

public class LottoMain {
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int lottoNum = InputView.buyLotto() / LOTTO_PRICE;
        ResultView.printLottoCount(lottoNum);

        LottoWallet lottoWallet = autoLottos(lottoNum);
        ResultView.printLottoNum(lottoWallet);

        LastWinner lastWinner = new LastWinner(InputView.getLastWinner());
        List<Integer> results = lottoWallet.compareWithLastLotto(lastWinner);
        ResultView.printDrawResult(results);

        Revenue revenue = new Revenue(results);
        ResultView.printPercentage(revenue.calculatePercentage(lottoNum * LOTTO_PRICE));
    }
}
