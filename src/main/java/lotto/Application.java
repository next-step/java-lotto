package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoCalculator;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int money = inputView.getMoney();

        LottoBuyer lottoBuyer = new LottoBuyer(money);

        ResultView.printLottoCount(lottoBuyer.getCount());
        ResultView.printLottos(lottoBuyer.getLottos());

        String lastWeekLottoValue = inputView.getLastWeekLottoNumbers();
        String lastWeekBonusBall = inputView.getBonusBallNumber();

        LottoCalculator lottoCalculator = new LottoCalculator(new WinningLotto(new Lotto(lastWeekLottoValue), lastWeekBonusBall), lottoBuyer.getLottos());

        ResultView.printChanceOfWinning(lottoCalculator, money);
    }
}
