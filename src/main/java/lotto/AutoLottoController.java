package lotto;

import lotto.domain.*;
import lotto.util.PrizeCalculatorUtil;
import lotto.util.StringUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

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

        int bonusNumber = inputView.inputSpecialNumber();
        // 추첨
        lottery(user, winningLotto, autoLottoMatchCount, bonusNumber);

        // 당첨 통계
        winningStatistics(autoLottoMatchCount, lottoCount);
    }

    private void displayLotto(User user) {
        for (Lotto lotto : user.getLottoList()) {
            resultView.displayLotto(lotto);
        }
    }

    private void lottery(User user, Lotto winningLotto, AutoLottoMatchCount autoLottoMatchCount, int bonusNumber) {
        for (Lotto lotto : user.getLottoList()) {
            autoLottoMatchCount.lottoCountPlus(winningLotto.winningLottoCount(lotto, bonusNumber));
        }
    }

    private void winningStatistics(AutoLottoMatchCount autoLottoMatchCount, int lottoCount) {
        resultView.displayStatisticsTitle();
        int total = 0;
        Map<Rank, WinningCount> resultLottoMatchCount = autoLottoMatchCount.getLottoMatchCount();
        TreeMap<Rank, WinningCount> treeMap = new TreeMap<>(resultLottoMatchCount);

        Iterator<Rank> lottoMatchKey = treeMap.descendingKeySet().iterator();
        while (lottoMatchKey.hasNext()) {
            Rank rank = lottoMatchKey.next();
            resultView.displayWinningStatistics(rank, resultLottoMatchCount.get(rank).getWinningCount());
            total += (rank.getWinningMoney() * resultLottoMatchCount.get(rank).getWinningCount());
        }

        resultView.displayProfits(PrizeCalculatorUtil.profitCalculation(total, lottoCount));
    }
}
