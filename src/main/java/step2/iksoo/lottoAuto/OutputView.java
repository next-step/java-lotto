package step2.iksoo.lottoAuto;

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

    public static void printResult(int[] resultWinners) {
        IntStream.range(0, resultWinners.length)
                .filter(matchesNumber -> matchesNumber >= 3)
                .forEach(matchesNumber -> printTextln(matchesNumber + "개 일치 (" + "원)- " + resultWinners[matchesNumber] + "개"));

        printTextln("총 수익률은 xxx입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
