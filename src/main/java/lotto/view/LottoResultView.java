package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoAmount;

import java.util.List;
import java.util.Map;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 23:10
 */
public class LottoResultView {

    private static final int[] winningCount = {3,4,5,6};

    public static void printPurchasedLotto(List<Lotto> lottos) {
        lottos.stream().map(Lotto::getLottoNumber).forEach(System.out::println);
    }

    public static void printLottoPurchaseCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }

    public static void printWinningLotto(List<WinningLottoAmount> winningLottoAmount) {
        Map<WinningLottoAmount, Long> lottoResult = WinningLottoAmount.lottoResult(winningLottoAmount);
        lottoResult.entrySet().forEach(result -> {
            WinningLottoAmount lottoAmount = result.getKey();
            System.out.println(String.format("%d개 일치 (%d원)- %d개", lottoAmount.getMatchCount(), lottoAmount.getAmount(), result.getValue()));
        });
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", rateOfReturn));
    }
}
