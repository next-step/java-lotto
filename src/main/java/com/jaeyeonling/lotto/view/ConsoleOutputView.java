package com.jaeyeonling.lotto.view;

import com.jaeyeonling.lotto.config.Env;
import com.jaeyeonling.lotto.domain.Lotto;
import com.jaeyeonling.lotto.domain.LottoGameReport;
import com.jaeyeonling.lotto.domain.LottoPrize;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public final class ConsoleOutputView {

    private static final PrintStream CONSOLE = System.out;

    private ConsoleOutputView() { }

    public static void printBuyingLotto(final List<Lotto> lottos) {
        print(String.format(Env.BUYING_ALERT_MESSAGE, lottos.size()));
        lottos.forEach(ConsoleOutputView::print);
    }

    public static void printReport(final LottoGameReport report) {
        ConsoleOutputView.newline();
        printWinningReportHeader();
        printWinningReportMatchTemplate(report);
        printWinningReportFooter(report);
    }

    private static void printWinningReportMatchTemplate(final LottoGameReport report) {
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> printWinningReportMatchTemplate(prize, report));
    }

    private static void printWinningReportMatchTemplate(final LottoPrize prize,
                                                        final LottoGameReport report) {
        final String message = String.format(Env.WINNING_REPORT_MATCH_TEMPLATE,
                prize.getCountOfMatch(), prize.getPrizeMoney(), report.getMatchCount(prize));

        ConsoleOutputView.print(message);
    }

    public static void print(final Object message) {
        CONSOLE.println(message);
    }

    public static void newline() {
        CONSOLE.println();
    }

    private static void printWinningReportHeader() {
        ConsoleOutputView.print(Env.WINNING_REPORT_HEADER);
    }

    private static void printWinningReportFooter(final LottoGameReport report) {
        ConsoleOutputView.print(String.format(Env.WINNING_REPORT_FOOTER, report.getReturnOnInvestment()));
    }
}
