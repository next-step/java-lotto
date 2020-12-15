package lotto.view;

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
     * @param lottoNumbers
     */
    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
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
}
