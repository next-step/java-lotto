package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ResultView {
    public static void printBuyCountForPrint(Lottos allAutomaticLottos, Lottos allManualLottos) {
        System.out.println("수동으로 " + allManualLottos.getElements().size() + "장 " + allAutomaticLottos.getElements().size() + "개를 구매했습니다.");
        for (Lotto lotto : allManualLottos.getElements()) {
            System.out.println(lotto.getLottoNumbers());
        }
        for (Lotto lotto : allAutomaticLottos.getElements()) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printLottoResult(WinningStatistics statistics) {
        System.out.println();
        System.out.println("당첨 통계\n---------");
        System.out.println(printInformation(statistics));
        System.out.println("총 수익률은 " + statistics.getTotalRateOfReturn() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    public static String printInformation(WinningStatistics statistics) {
        return Arrays.stream(WinningGrade.values())
                .filter(key -> key != WinningGrade.ETC)
                .sorted(Comparator.comparing(WinningGrade::getPrizeMoney))
                .map(key -> matchCountPrint(key) + isBonusMatchPrint(key) + " (" + key.getPrizeMoney() + "원)" + "- " + statistics.statisticsCount(key) + "개")
                .collect(Collectors.joining("\n"));
    }

    public static String isBonusMatchPrint(WinningGrade winningGrade) {
        if (winningGrade.isNeedBonusMatch() && winningGrade.isBonusMatch()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public static String matchCountPrint(WinningGrade winningGrade) {
        return winningGrade.getMatchCount() + "개 일치";
    }




}
