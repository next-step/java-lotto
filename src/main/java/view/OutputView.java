package view;

import lotto.LottoMatch;
import lotto.LottosResult;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void showResult(int result) {
        System.out.println("result = " + result);
    }

    public static void showLottoQuantity(int lottoQuantity) {
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public static void showLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void showLottoMatchResult(LottosResult lottosResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoMatch.values())
                .filter(match -> match != LottoMatch.NONE)
                .forEach(match -> {
                    int count = lottosResult.getLottoMatchCount(match);
                    System.out.println(match.toString() + " - " + count + "개 일치");
                });
    }

    public static void showTotalYieldRate(double totalYieldRate) {
        System.out.printf("총 수익률은 %.2f입니다.\n", totalYieldRate);
    }
}
