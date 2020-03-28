package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.WinningType;

import java.util.List;

public class ResultView {
    public static void printLottoNumbers(LottoBundle lottoBundle) {
        List<Lotto> lottos = lottoBundle.getLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(LottoResult lottoResult) {
        printLottoResult(lottoResult);
        printEarningRate(lottoResult);
    }

    private static void printLottoResult(LottoResult lottoResult) {
        WinningType[] winningTypes = WinningType.values();
        for (WinningType winningType : winningTypes) {
            System.out.println(String.format("%d개 일치 (%.0f원) - %d개",
                    winningType.getMatchCount(), winningType.getWinningAmount(), lottoResult.countByWinningtype(winningType)));
        }
    }

    private static void printEarningRate(LottoResult lottoResult) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoResult.calculateEarningRate()));
    }
}
