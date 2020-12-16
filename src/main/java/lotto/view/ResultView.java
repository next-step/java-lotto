package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoWinPrize;
import lotto.domain.LottoWinResult;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
     * 발급된 로또 번호들을 출력합니다.
     * @param lottos
     */
    public void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().stream().forEach(this::printLottoNumbers);
    }

    /**
     * 당첨 통계를 출력합니다.
     * @param lottoWinResult
     */
    public void printWinStatistics(LottoWinResult lottoWinResult) {
        System.out.println("당첨 통계\n---------");
        this.printWinPrizes(lottoWinResult);
    }


    /**
     * 로또 상금 별 당첨 수 출력
     * @param lottoWinResult
     */
    private void printWinPrizes(LottoWinResult lottoWinResult) {
        for (LottoWinPrize lottoWinPrize : LottoWinPrize.values()) {
            System.out.printf(ResultView.PRINT_WIN_PRIZE_FORMAT
                    , lottoWinPrize.getMatchedCount()
                    , lottoWinPrize.getPrize()
                    , lottoWinResult.getCount(lottoWinPrize));
        }
    }

    /**
     * @param earningRatio
     */
    public void printPriceEarningRatio(double earningRatio) {
        System.out.print("총 수익률은 " + earningRatio + "입니다.");
        if(earningRatio < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
