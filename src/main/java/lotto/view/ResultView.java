package lotto.view;

import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.WinningType;

import java.util.Arrays;

public class ResultView {
    public static void printLottoNumbers(LottoBundle lottoBundle) {
        lottoBundle.getLottos().stream()
                .forEach(System.out::println);
    }

    public static void printResult(LottoResult lottoResult) {
        printLottoResult(lottoResult);
        printEarningRate(lottoResult);
    }

    private static void printLottoResult(LottoResult lottoResult) {
        Arrays.stream(WinningType.values())
                .forEach(winningType -> {
                    printLottoResultDetail(lottoResult, winningType);
                });
    }

    private static void printLottoResultDetail(LottoResult lottoResult, WinningType winningType) {
        if (winningType.equals(WinningType.SECOND)) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%.0f원) - %d개",
                    winningType.getMatchCount(), winningType.getWinningAmount(), lottoResult.countByWinningtype(winningType)));
            return;
        }
        System.out.println(String.format("%d개 일치 (%.0f원) - %d개",
                winningType.getMatchCount(), winningType.getWinningAmount(), lottoResult.countByWinningtype(winningType)));
    }

    private static void printEarningRate(LottoResult lottoResult) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoResult.calculateEarningRate()));
    }
}
