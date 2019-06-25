package step3.iksoo.lotto2rd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    public static void printAskBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
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

    public static void printResult(Map<Rank, Integer> matchResult) {
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank.getCountOfMatch() >= Rank.FIFTH.getCountOfMatch())
                .peek(rank -> printTextln(rank.getCountOfMatch() + "개 일치 " + rank.getRankName() + " (" + rank.getWinningMoney() + "원)- " + matchResult.get(rank) + "개"))
                .collect(Collectors.toList());
    }

    public static void printRateProfit(double calculateRateProfit) {
        printTextln("총 수익률은 " + calculateRateProfit + "입니다.");
    }
}
