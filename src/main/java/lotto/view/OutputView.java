package lotto.view;

import lotto.model.Rank;
import lotto.model.Statistics;
import lotto.model.Ticket;

public class OutputView {
    private static final String MESSAGE_OF_NUMBER_OF_TICKET = "%d개를 구매했습니다.";
    private static final String MESSAGE_OF_RESULT_INTRO = "\n당첨 통계\n---------";
    private static final String MESSAGE_OF_WINNING_RESULT = "%d개 일치 (%s원)- %d개";
    private static final String MESSAGE_OF_SECOND_WINNING_RESULT = "%d개 일치, 보너스 볼 일치 (%s원)- %d개";
    private static final String MESSAGE_OF_PROFIT_RATIO = "총 수익률은 %.2f입니다.";

    public static void printNumberOfTickets(int numberOfTickets) {
        System.out.println(String.format(MESSAGE_OF_NUMBER_OF_TICKET, numberOfTickets));
    }

    public static void printTicket(Ticket ticket) {
        System.out.println(ticket);
    }

    public static void printResult(Statistics statistics) {
        System.out.println(MESSAGE_OF_RESULT_INTRO);

        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.MISS)) {
                break;
            }
            int countOfMatch = rank.getCountOfMatch();
            int winningMoney = rank.getWinningMoney().toInteger();
            int countOfWinning = statistics.getCountOfWinning(rank);

            String outputMessage = MESSAGE_OF_WINNING_RESULT;
            if (rank.equals(Rank.SECOND)) {
                outputMessage = MESSAGE_OF_SECOND_WINNING_RESULT;
            }
            System.out.println(String.format(outputMessage, countOfMatch, winningMoney, countOfWinning));
        }
    }

    public static void printProfitRatio(double profitRatio) {
        System.out.println(String.format(MESSAGE_OF_PROFIT_RATIO, profitRatio));
    }
}
