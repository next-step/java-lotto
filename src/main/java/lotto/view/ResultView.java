package lotto.view;

import lotto.model.BoughtLotto;
import lotto.model.WinningRecord;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private ResultView() {
    }

    public static void printBuyLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println("\n수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");
    }

    public static void printBoughtLottos(List<BoughtLotto> boughtLottos) {
        for (BoughtLotto boughtLotto : boughtLottos) {
            System.out.println(boughtLotto.getIntegerTypeNumbers());
        }
    }

    public static void printWinningStatics(Map<Integer, WinningRecord> winningStatics) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");

        for (int rank = 5; rank >= 1; rank--) {
            WinningRecord winningRecord = winningStatics.get(rank);

            printWinningResult(rank, winningRecord);
        }
    }

    private static void printWinningResult(int rank, WinningRecord winningRecord) {
        int matchCount = winningRecord.getMatchCount();
        int prize = winningRecord.getPrize();
        int winningCount = winningRecord.getWinningCount();

        String resultMessage = matchCount + "개 일치";

        if (rank == 2) {
            resultMessage += ", 보너스 볼 일치";
        }

        resultMessage += " (" + prize + "원)- " + winningCount + "개";

        System.out.println(resultMessage);
    }

    public static void printReturnRate(float returnRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", returnRate) + "입니다.");
    }

}