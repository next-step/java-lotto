package step4.view;

import step4.LottoBucket;
import step4.LottoWinStatistics;
import step4.enums.DrawResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultView {
    public static void printLottoQuantity(LottoBucket manualLottoBucket, LottoBucket autoLottoBucket) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualLottoBucket.size(), autoLottoBucket.size());
    }

    public static void printAllLottoEntries(LottoBucket manualLottoBucket, LottoBucket autoLottoBucket) {
        System.out.println(manualLottoBucket.toOutputString());
        System.out.println(autoLottoBucket.toOutputString());
    }

    public static void printLottoWinStatus(LottoWinStatistics lottoWinStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<String> outputList =  Arrays.stream(DrawResult.values())
                .filter(win -> win.matchCount() > 0)
                .map(win -> {
                    int count = lottoWinStatistics.countLottoEntriesByMatch(win);

                    return String.format("%d개 일치%s (%d원)- %d개",
                            win.matchCount(), getBonusBallString(win), win.prize(), count);
                })
                .collect(Collectors.toList());

        reverseList(outputList).forEach(System.out::println);
    }

    private static List<String> reverseList(List<String> outputList) {
        Collections.reverse(outputList);

        return outputList;
    }

    private static String getBonusBallString(DrawResult win) {
        return win.bonusMatch() ? ", 보너스 볼" : "";
    }

    public static void printProfitRate(LottoWinStatistics lottoWinStatistics) {
        System.out.printf("총 수익률은 %.2f입니다.(1.00보다 낮은 경우 손해)\n", lottoWinStatistics.getProfitRate());
    }
}
