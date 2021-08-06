package step2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultView {
    public static void printLottoQuantity(LottoBucket lottoBucket) {
        System.out.printf("%d개를 구매했습니다.%n", lottoBucket.size());
    }

    public static void printAllLottoEntries(LottoBucket lottoBucket) {
        System.out.println(lottoBucket.toOutputString());
    }

    public static void printLottoWinStatus(LottoWinStatistics lottoWinStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<String> outputList =  Arrays.stream(LottoWin.values())
                .filter(win -> win.matchCount() > 0)
                .map(win -> {
                    int count = lottoWinStatistics.countLottoEntriesByLottoWin(win);

                    return String.format("%d개 일치%s (%d원)- %d개",
                            win.matchCount(), getBonusBallString(win), win.prize(), count);
                })
                .collect(Collectors.toList());

        listReverse(outputList).forEach(System.out::println);
    }

    private static List<String> listReverse(List<String> outputList) {
        Collections.reverse(outputList);

        return outputList;
    }

    private static String getBonusBallString(LottoWin win) {
        return win.bonusMatch() ? ", 보너스 볼" : "";
    }

    public static void printProfitRate(LottoWinStatistics lottoWinStatistics) {
        System.out.printf("총 수익률은 %.2f입니다.(1.00보다 낮은 경우 손해)\n", lottoWinStatistics.getProfitRate());
    }
}
