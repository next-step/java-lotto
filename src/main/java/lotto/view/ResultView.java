package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoWinPrize;

import java.util.List;

public class ResultView {

    private static final String PRINT_WIN_PRIZE_FORMAT = "%d개 일치 (%d원)- %d개\n";

    /**
     * 구매한 로또의 갯수를 출력합니다.
     * @param amount
     */
    public void printNumberOfPurchasedLotto(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    /**
     * 발급된 로또 번호를 출력합니다.
     * @param lotto
     */
    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    /**
     * 당첨 통계를 출력합니다.
     * @param lottoWinPrizes
     */
    public void printWinStatistics(List<LottoWinPrize> lottoWinPrizes) {
        System.out.println("당첨 통계\n---------");
        this.printWinPrizes(lottoWinPrizes);
    }


    /**
     * 로또 상금 별 당첨 수 출력
     * @param lottoWinPrizes 
     */
    private void printWinPrizes(List<LottoWinPrize> lottoWinPrizes) {
        for (LottoWinPrize lottoWinPrize : lottoWinPrizes) {
            System.out.printf(ResultView.PRINT_WIN_PRIZE_FORMAT
                                , lottoWinPrize.getMatchedCount()
                                , lottoWinPrize.getPrize()
                                , lottoWinPrize.getCount());
        }
    }

    /**
     * @param lottoWinPrizes
     */
    public void printPriceEarningRatio(double lottoWinPrizes) {
        System.out.print("총 수익률은 " + lottoWinPrizes + "입니다.");
        if(lottoWinPrizes < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
