package step2.view;

import step2.domain.LottoResultReport;
import step2.domain.LottoTicket;
import step2.domain.PrizeMoney;

import java.util.List;

public class ResultView {

    private static final int MINIMUM_MATH_COUNT = 3;
    private static final int MAXIMUM_MATH_COUNT = 6;

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printLottoTicket(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.printTicket());
        }
        printBlankLine();
    }

    public static void printResultReport(LottoResultReport lottoResultReport) {
        for (int i = MINIMUM_MATH_COUNT; i < MAXIMUM_MATH_COUNT + 1; i++) {
            PrizeMoney prizeMoney = PrizeMoney.toPrizeMoney(i);
            printMessage(i + "개 일치 (" + PrizeMoney.toPrizeMoney(i).prizeMoney() + ") - " + lottoResultReport.findReportByMatchCount(prizeMoney) + "개");
        }
    }
}
