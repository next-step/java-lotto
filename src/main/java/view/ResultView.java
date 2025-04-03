package view;

import domain.model.LottoNumbers;
import domain.model.LottoWallet;
import domain.model.MatchResult;

import java.util.List;
import java.util.stream.Collectors;

import static constant.LottoConstants.MATCH_PRICES;

public class ResultView {
    public static void printPurchasedLottos(LottoWallet lottoWallet) {
        int count = lottoWallet.getCount();
        printMessage(count + "개를 구매했습니다.");
        for (LottoNumbers lotto : lottoWallet.getLottos()) {
            printLottoNumbers(lotto.getNumbers());
        }
    }

    public static void printMatchResult(MatchResult matchResults) {
        printMessage("당첨 통계");
        printMessage("---------");
        for (int matchCount : MATCH_PRICES.keySet()) {
            int price = MATCH_PRICES.get(matchCount);
            int count = matchResults.getCount(matchCount);
            printMessage(matchCount + "개 일치 (" + price + "원)- " + count + "개");
        }
    }

    public static void printProfit(double profit) {
        printMessage("총 수익률은 " + String.format("%.2f", profit) + "입니다.");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printLottoNumbers(List<Integer> lottoNumbers) {
        String formattedNumbers = arrayToString(lottoNumbers);
        printMessage(formattedNumbers);
    }

    private static String arrayToString(List<Integer> array) {
        return "[" + array.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
