package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.List;

public class ResultView {

    public void PurchaseHistory(long purchaseCount, Lotto lotto) {

        System.out.println(purchaseCount + "개를 구매했습니다.");
        lotto.printToLotto();
    }

    public void printToWinningStatistics(Lotto lotto) {

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        lotto.printToResultWinning();
        lotto.printToTotAteOfReturn();

    }
}
