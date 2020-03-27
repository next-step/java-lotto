package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int money = inputView.getMoney();

        LottoBuyer lottoBuyer = new LottoBuyer(money);

        ResultView.printLottoCount(lottoBuyer.getCount());
        ResultView.printLottos(lottoBuyer.getLottos());

        List<Integer> lottoNumbers = inputView.getLastWeekLottoNumbers();

        LottoCalculator lottoCalculator = new LottoCalculator(lottoNumbers, lottoBuyer.getLottos());

        ResultView.printChanceOfWinning(lottoCalculator, money);
    }
}
