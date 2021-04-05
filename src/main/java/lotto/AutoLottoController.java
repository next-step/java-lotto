package lotto;

import lotto.domain.*;
import lotto.util.PrizeCalculatorUtil;
import lotto.util.StringUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Iterator;
import java.util.Map;

public class AutoLottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public AutoLottoController() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void run() {
        // 금액 입력
        int lottoCount = inputView.inputPrize();
        // 로또 구매 갯수 표시
        resultView.displayLottoCount(lottoCount);

        User user = new User();
        // 로또 구매
        user.buyLotto(lottoCount);
        // 구매 로또 표시
        displayLotto(user);

        // 당첨 번호 입력
        Lotto winningLotto = new Lotto(StringUtil.stringToList(inputView.inputWinningLotto()));

        AutoLottoMatchCount autoLottoMatchCount = new AutoLottoMatchCount();

        // 추첨
        lottery(user, winningLotto, autoLottoMatchCount);

        // 당첨 통계
        winningStatistics(autoLottoMatchCount, lottoCount);
    }

    private void displayLotto(User user) {
        for (Lotto lotto : user.getLottoList()) {
            resultView.displayLotto(lotto);
        }
    }

    private void lottery(User user, Lotto winningLotto, AutoLottoMatchCount autoLottoMatchCount) {
        for (Lotto lotto : user.getLottoList()) {
            autoLottoMatchCount.lottoCountPlus(winningLotto.winningLottoCount(lotto));
        }
    }

    private void winningStatistics(AutoLottoMatchCount autoLottoMatchCount, int lottoCount) {
        resultView.displayStatisticsTitle();
        int total = 0;
        Map<Integer, WinningCount> resultLottoMatchCount = autoLottoMatchCount.getLottoMatchCount();
        Iterator<Integer> lottoMatchKey = resultLottoMatchCount.keySet().iterator();
        while (lottoMatchKey.hasNext()) {
            Integer number = lottoMatchKey.next();
            Prize prize = Prize.of(number);
            resultView.displayWinningStatistics(number, prize, resultLottoMatchCount.get(number).getWinningCount());
            total += (prize.getPrize() * resultLottoMatchCount.get(number).getWinningCount());
        }

        resultView.displayProfits(PrizeCalculatorUtil.profitCalculation(total, lottoCount));
    }
}
