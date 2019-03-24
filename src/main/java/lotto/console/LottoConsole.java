package lotto.console;

import lotto.application.LottoService;
import lotto.application.ResultView;
import lotto.application.WinningStatisticsView;
import lotto.domain.Lotto;
import lotto.domain.LottoPaper;
import lotto.domain.WinningOrder;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class LottoConsole {
    private static final Scanner CONSOLE_SCANNER = new Scanner(System.in);

    public static void run(final LottoService lottoService) {
        final LottoPaper lottoPaper = lottoService.issue(enterAmount());
        printLottoPaper(lottoPaper);
        final ResultView resultView = lottoService.viewResults(lottoPaper, enterWinningNumber(), enterBonusNumber());
        printResult(resultView);
    }

    private static int enterAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return CONSOLE_SCANNER.nextInt();
    }

    private static String enterWinningNumber() {
        CONSOLE_SCANNER.nextLine();
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return CONSOLE_SCANNER.nextLine();
    }

    private static int enterBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return CONSOLE_SCANNER.nextInt();
    }

    private static void printLottoPaper(final LottoPaper lottoPaper) {
        System.out.println(lottoPaper.getLottoSize() + "개를 구매했습니다.");
        lottoPaper.get()
                .stream()
                .map(LottoConsole::changeToLottoPrintFormat)
                .forEach(System.out::println)
        ;
    }

    private static void printResult(final ResultView resultView) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        printStatistics(resultView.getStatistics());
        printRoi(resultView.getRoi());
    }

    private static void printStatistics(final WinningStatisticsView statistics) {
        statistics.get()
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey() != WinningOrder.LAST_PLACE)
                .sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(changeToStatisticsPrintFormat(entry)))
        ;
    }

    private static void printRoi(final double roi) {
        System.out.println("총 수익률은 " + roi + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private static String changeToLottoPrintFormat(final Lotto lotto) {
        return new StringBuilder()
                .append(lotto.getNumbers().get())
                .toString()
                ;
    }

    private static String changeToStatisticsPrintFormat(final Map.Entry<WinningOrder, Long> entry) {
        return new StringBuilder()
                .append(entry.getKey().getPhrase())
                .append(" (")
                .append(entry.getKey().getAmount())
                .append("원)- ")
                .append(entry.getValue())
                .append("개")
                .toString()
                ;
    }
}
