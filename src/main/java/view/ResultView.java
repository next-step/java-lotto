package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static domain.constant.LottoConstants.MATCH_PRICES;

public class ResultView {
    public static void printPurchasedLottoCount(int count) {
        printMessage(count + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        printMessage(arrayToString(lottoNumbers));
    }

    public static void printMatchResult(Map<Integer, Integer> matchResults) {
        printMessage("당첨 통계");
        printMessage("---------");
        for (int matchCount : matchResults.keySet()) {
            int price = MATCH_PRICES.get(matchCount);
            int count = matchResults.get(matchCount);
            printMessage(matchCount + "개 일치 (" + price + "원)- " + count + "개");
        }
    }

    public static void printProfit(double profit) {
        printMessage("총 수익률은 " + String.format("%.2f", profit) + "입니다.");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static String arrayToString(List<Integer> array) {
        return "[" + array.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
