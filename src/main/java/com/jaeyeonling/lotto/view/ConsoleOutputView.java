package com.jaeyeonling.lotto.view;

import com.jaeyeonling.lotto.domain.Lotto;
import com.jaeyeonling.lotto.domain.LottoGameReport;
import com.jaeyeonling.lotto.domain.LottoPrize;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public final class ConsoleOutputView {

    private static final String BUYING_ALERT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_REPORT_HEADER = "당첨 통계\n---------";
    private static final String WINNING_REPORT_MATCH_TEMPLATE = "%d개 일치 (%d원) - %d개";
    private static final String WINNING_REPORT_FOOTER = "총 수익률은 %f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static final PrintStream CONSOLE = System.out;

    private ConsoleOutputView() { }

    public static void printBuyingLotto(final List<Lotto> lottos) {
        print(String.format(BUYING_ALERT_MESSAGE, lottos.size()));
        lottos.forEach(ConsoleOutputView::print);
    }

    public static void printReport(final LottoGameReport report) {
        ConsoleOutputView.newline();
        printWinningReportHeader();
        printWinningReportMatchTemplate(report);
        printWinningReportFooter(report);
    }

    public static void print(final Object message) {
        CONSOLE.println(message);
    }

    public static void newline() {
        CONSOLE.println();
    }

    private static void printWinningReportHeader() {
        ConsoleOutputView.print(WINNING_REPORT_HEADER);
    }

    private static void printWinningReportMatchTemplate(final LottoGameReport report) {
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> printWinningReportMatchTemplate(prize, report));
    }

    private static void printWinningReportMatchTemplate(final LottoPrize prize,
                                                        final LottoGameReport report) {
        final String message = String.format(WINNING_REPORT_MATCH_TEMPLATE,
                prize.getCountOfMatch(), prize.getPrizeMoney(), report.getMatchCount(prize));

        ConsoleOutputView.print(message);
    }

    private static void printWinningReportFooter(final LottoGameReport report) {
        ConsoleOutputView.print(String.format(WINNING_REPORT_FOOTER, report.getReturnOnInvestment()));
    }
}
