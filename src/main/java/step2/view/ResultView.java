package step2.view;

import step2.domain.LottoResultReport;
import step2.domain.LottoTicket;
import step2.domain.Rank;

import java.util.List;

public class ResultView {

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
        Rank[] values = Rank.values();
        for (Rank rank : values) {
            printEachLottoRank(lottoResultReport, rank);
        }
    }

    private static void printEachLottoRank(LottoResultReport lottoResultReport, Rank rank) {
        if (rank == Rank.MISS) {
            return;
        }
        printMessage(rank.message() + " - " + lottoResultReport.findReportByMatchCount(rank) + "개");
    }
}
