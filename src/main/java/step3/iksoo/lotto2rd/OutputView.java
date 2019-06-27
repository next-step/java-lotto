package step3.iksoo.lotto2rd;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OutputView {
    private static final String WINNER_PRINT_FORMAT = "%d개 일치 (%d원) - %d개\n";
    private static final String SECOND_WINNER_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";

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
        Rank.winValues().stream()
                .forEach(rank -> System.out.printf(rank == Rank.SECOND ? SECOND_WINNER_PRINT_FORMAT : WINNER_PRINT_FORMAT, rank.getCountOfMatch(), rank.getWinningMoney(), matchResult.get(rank)));
    }

    public static void printRateProfit(double calculateRateProfit) {
        printTextln("총 수익률은 " + calculateRateProfit + "입니다.");
    }
}
