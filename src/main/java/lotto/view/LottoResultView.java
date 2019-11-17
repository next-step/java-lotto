package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningLottoAmount;

import java.util.List;
import java.util.Map;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 23:10
 */
public class LottoResultView {

    public static void printPurchasedLotto(List<Lotto> lottos) {
        lottos.stream().map(Lotto::getLottoNumber).forEach(System.out::println);
    }

    public static void printLottoPurchaseCount(int autoLottoCount, int manualLottoCount) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d 구매했습니다.", manualLottoCount, autoLottoCount));
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
