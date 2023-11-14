package lotto;

import lotto.controller.LottoInput;
import lotto.model.Lottery;
import lotto.model.Lotto;
import lotto.model.constants.Dividend;
import lotto.view.LottoOutput;

import java.util.List;

import static lotto.model.LottoFactory.*;
import static lotto.util.LottoUtil.*;

public class simulator {
    public static void main(String[] args) {
        int purchaseAmount = LottoInput.getInput();
        int lottoCnt = getLottoCount(purchaseAmount);
        LottoOutput.viewLottoCount(lottoCnt);
        List<Lotto> lottos = generateLotto(lottoCnt);
        LottoOutput.viewLottoDetail(lottos);
        List<Integer> winnerNumbers = LottoInput.getWinningNumber();
        Lottery lottery = new Lottery(winnerNumbers, lottos);
        for (int correctCount = 3; correctCount <= 6; correctCount++) {
            int winCount = lottery.checkForWin(correctCount);
            lottery.depositMoney(Dividend.getMoney(correctCount, winCount));
            LottoOutput.viewLottoTotal(correctCount, winCount);
        }
        System.out.println(lottery.money());
    }
}
