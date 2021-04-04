package step2;

import step2.domain.AutoLottoMatchCount;
import step2.domain.Lotto;
import step2.domain.Prize;
import step2.domain.User;
import step2.util.PrizeCalculatorUtil;
import step2.util.StringUtil;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.HashMap;
import java.util.Iterator;

public class AutoLottoController {

    InputView inputView;
    ResultView resultView;
    User user;
    Lotto defaultLotto;
    AutoLottoMatchCount autoLottoMatchCount;

    public AutoLottoController() {
        inputView = new InputView();
        resultView = new ResultView();
        user = new User();
        defaultLotto = new Lotto();
        autoLottoMatchCount = new AutoLottoMatchCount();
    }

    public void run() {
        // 금액 입력
        int lottoCount = inputView.inputPrize();
        // 로또 구매 갯수 표시
        resultView.displayLottoCount(lottoCount);

        // 로또 구매
        buyLotto(lottoCount);
        // 구매 로또 표시
        displayLotto();

        // 당첨 번호 입력
        Lotto winningLotto = new Lotto(StringUtil.stringToList(inputView.inputWinningLotto()));

        // 추첨
        lottery(winningLotto);

        // 당첨 통계
        winningStatistics(lottoCount);
    }

    private void buyLotto(int count) {
        for (int i = 0; i < count; i++) {
            user.buyLottos(defaultLotto);
        }
    }

    private void displayLotto() {
        for (Lotto lotto : user.getLottoList()) {
            resultView.displayLotto(lotto);
        }
    }

    private void lottery(Lotto winningLotto) {
        for (Lotto lotto : user.getLottoList()) {
            autoLottoMatchCount.lottoCountPlus(user.winningConfirm(winningLotto, lotto));
        }
    }


    private void winningStatistics(int lottoCount) {
        resultView.displayStatisticsTitle();
        int total = 0;
        HashMap<Integer, Integer> resultLottoMatchCount = autoLottoMatchCount.getLottoMatchCount();
        Iterator<Integer> lottoMatchKey = resultLottoMatchCount.keySet().iterator();
        while (lottoMatchKey.hasNext()) {
            Integer number = lottoMatchKey.next();
            Prize prize = Prize.of(number);
            resultView.displayWinningStatistics(number, prize, resultLottoMatchCount.get(number));
            total += (prize.getPrize() * resultLottoMatchCount.get(number));
        }

        resultView.displayProfits(PrizeCalculatorUtil.profitCalculation(total, lottoCount));
    }
}
