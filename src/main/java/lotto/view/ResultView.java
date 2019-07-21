package lotto.view;

import lotto.domain.*;

public class ResultView {
    public static final String DELIMITER_STRING = "\n";
    public static final String DELIMITER_NUMBERS = ", ";

    public static void printResult(LottoResult result) {
        println("\n당첨 통계");
        println("---------");
        println(getWinResult(LottoWin.FIFTH, result.getResultOf(LottoWin.FIFTH)));
        println(getWinResult(LottoWin.FOURTH, result.getResultOf(LottoWin.FOURTH)));
        println(getWinResult(LottoWin.THIRD, result.getResultOf(LottoWin.THIRD)));
        println(getWinResult(LottoWin.SECOND, result.getResultOf(LottoWin.SECOND)));
        println(getWinResult(LottoWin.FIRST, result.getResultOf(LottoWin.FIRST)));
        println("총 수익률은 " + result.getProfitRate() + "입니다.");
    }

    private static String getWinResult(LottoWin win, int count) {
        int earning = win.getEarning();

        StringBuilder builder = new StringBuilder();
        builder.append(win.getCountOfMatch());
        builder.append("개 일치");
        if (win == LottoWin.SECOND) {
            builder.append(", 보너스 볼 일치");
        }
        builder.append(" (");
        builder.append(earning);
        builder.append("원) - ");
        builder.append(count);
        builder.append("개");

        return builder.toString();
    }

    public static void printWallet(LottoWallet wallet) {
        printTicketsStatus(wallet);
        printTickets(wallet.getGenerated());
        printTickets(wallet.getPicked());
    }

    private static void printTicketsStatus(LottoWallet wallet) {
        int sizeOfGenerated = wallet.getGenerated().size();
        int sizeOfPicked = wallet.getPicked().size();

        println("수동으로 " + sizeOfPicked + "장, 자동으로 " + sizeOfGenerated + "개를 구매했습니다.");
    }

    public static void printTickets(LottoTickets tickets) {
        StringBuilder builder = new StringBuilder();

        for (LottoTicket ticket : tickets.getTickets()) {
            builder.append(printTicket(ticket));
            builder.append(DELIMITER_STRING);
        }

        if (builder.length() == 0) return;

        println(builder.substring(0, builder.length() - DELIMITER_STRING.length()));
    }

    private static String printTicket(LottoTicket ticket) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (LottoNumber number : ticket.getTicket()) {
            builder.append(number).append(", ");
        }

        int max = builder.length();
        builder.delete(max - DELIMITER_NUMBERS.length(), max);
        builder.append("]");

        return builder.toString();
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
