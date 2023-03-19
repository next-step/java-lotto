package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.WinningGrade;
import lotto.domain.WinningStatistics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class ResultView {
    public static void printBuyCountForPrint(LottoGame lottoGame) {
        System.out.println(lottoGame.getBuyCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottoGame.getAllLottos()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printLottoResult(WinningStatistics statistics) {
        System.out.println();
        System.out.println("당첨 통계\n---------");
        System.out.println(printInformation(statistics));
        System.out.println("총 수익률은 " + statistics.getTotalRateOfReturnForPrint() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
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
