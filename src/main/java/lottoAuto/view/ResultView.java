package lottoAuto.view;

import lottoAuto.domain.Lotto;

public class ResultView {
    public void purchaseHistory(long purchaseCount, Lotto lotto) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
        lotto.printToLottoNumber();
    }

    public void printToWinningStatistics(Lotto lotto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        lotto.printToResultWinning();
        lotto.printToTotAteOfReturn();
    }
}
