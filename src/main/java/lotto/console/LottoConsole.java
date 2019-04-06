package lotto.console;

import lotto.application.LottoService;
import lotto.application.ResultView;
import lotto.application.WinningStatisticsView;
import lotto.domain.Lotto;
import lotto.domain.LottoPaper;
import lotto.domain.WinningOrder;

import java.util.*;

public class LottoConsole {
    private static final Scanner CONSOLE_SCANNER = new Scanner(System.in);

    public static void run(final LottoService lottoService) {
        final int amount = enterAmount();
        final int manualCount = enterManualCount();
        final List<String> manualNumbers = enterManualNumbers(manualCount);
        final LottoPaper lottoPaper = lottoService.issue(amount, manualNumbers);
        printLottoPaper(lottoPaper);
        final ResultView resultView = lottoService.viewResults(lottoPaper, enterWinningNumber(), enterBonusNumber());
        printResult(resultView);
    }

    private static int enterAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return CONSOLE_SCANNER.nextInt();
    }

    private static int enterManualCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return CONSOLE_SCANNER.nextInt();
    }

    private static List<String> enterManualNumbers(final int manualCount) {
        CONSOLE_SCANNER.nextLine();
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        final List<String> result = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            result.add(CONSOLE_SCANNER.nextLine());
        }
        return result;
    }

    private static String enterWinningNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return CONSOLE_SCANNER.nextLine();
    }

    private static int enterBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return CONSOLE_SCANNER.nextInt();
    }

    private static void printLottoPaper(final LottoPaper lottoPaper) {
        printPurchaseHistory(lottoPaper);
        lottoPaper.get()
                .stream()
                .map(LottoConsole::changeToLottoPrintFormat)
                .forEach(System.out::println)
        ;
    }

    private static void printPurchaseHistory(final LottoPaper lottoPaper) {
        System.out.println(
                "\n수동으로 "
                        + lottoPaper.getManualSize()
                        + "장, 자동으로 "
                        + lottoPaper.getAutomaticSize()
                        + "개를 구매했습니다."
        );
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
        System.out.println(
                "총 수익률은 "
                        + String.format("%.2f", roi)
                        + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        );
    }

    private static String changeToLottoPrintFormat(final Lotto lotto) {
        return new StringBuilder()
                .append(lotto.getNumbers().get())
                .toString()
                ;
    }

    private static String changeToStatisticsPrintFormat(final Map.Entry<WinningOrder, Long> entry) {
        return new StringBuilder()
                .append(changeToWinningOrderPrintFormat(entry.getKey()))
                .append(" (")
                .append(entry.getKey().getAmount())
                .append("원)- ")
                .append(entry.getValue())
                .append("개")
                .toString()
                ;
    }

    private static String changeToWinningOrderPrintFormat(final WinningOrder winningOrder) {
        if (winningOrder == WinningOrder.FIRST_PLACE) {
            return "6개 일치";
        }
        if (winningOrder == WinningOrder.SECOND_PLACE) {
            return "5개 일치, 보너스 볼 일치";
        }
        if (winningOrder == WinningOrder.THIRD_PLACE) {
            return "5개 일치";
        }
        if (winningOrder == WinningOrder.FOURTH_PLACE) {
            return "4개 일치";
        }
        return "3개 일치";
    }
}
