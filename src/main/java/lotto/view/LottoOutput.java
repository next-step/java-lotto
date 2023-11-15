package lotto.view;

import lotto.model.Lottery;
import lotto.model.Lotto;
import lotto.model.BuyLotto;
import lotto.model.constants.Dividend;

import java.util.List;

public class LottoOutput {

    public void viewLottoCount(BuyLotto bank) {
        System.out.println(bank.purchaseCount() + "개를 구매했습니다.");
    }

    public void viewLottoDetail(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.lottoNumbers());
        }
        System.out.println();
    }

    public void viewTotalIncomeRatio(Lottery lottery, BuyLotto buyLotto) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottery.getInvestment(buyLotto.purchaseAmount())) + "입니다.");
    }

    public void viewCorrectLottos(Lottery lottery){
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 3; i <= 6; i++) {
            viewCorrectLotto(i, lottery.checkForWin(i));
        }
    }

    public void viewCorrectLotto(int correctCount, int count) {
        System.out.println(correctCount + "개 일치 (" + Dividend.getDividend(correctCount).dividendAmount() + "원) - " + count + "개");
    }
}
