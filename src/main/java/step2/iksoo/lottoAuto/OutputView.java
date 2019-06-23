package step2.iksoo.lottoAuto;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OutputView {
    public static void printBlankLine() {
        System.out.println();
    }

    public static void printAskOrder() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printOrderCheck(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void printAskWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printText(Object text) {
        System.out.print(text);
    }

    public static void printTextln(Object text) {
        System.out.println(text);
    }

    public static void printLottos(List<Lotto> lottos) {
        IntStream.range(0, lottos.size())
                .forEach(n -> printTextln(lottos.get(n).getLotto()));
        printBlankLine();
    }

    public static int printResult(Map<Integer, Integer> resultWinners) {
        LottoPrize[] lottoPrize = LottoPrize.values();

        int sumPrize = IntStream.range(3, resultWinners.size())
                .peek(matchesNumber -> printTextln(matchesNumber + "개 일치 (" + lottoPrize[matchesNumber].getGradePrize() + "원)- " + resultWinners.get(matchesNumber) + "개"))
                .map(matchesNumber -> lottoPrize[matchesNumber].getGradePrize() * resultWinners.get(matchesNumber))
                .sum();
        return sumPrize;
    }

    public static void printRateProfit(double calculateRateProfit) {
        printTextln("총 수익률은 " + calculateRateProfit + "입니다.");
    }
}
