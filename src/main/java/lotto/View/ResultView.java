package lotto.View;

import java.util.List;

import lotto.Model.GameResult;
import lotto.Model.Profit;
import lotto.Model.Ticket;


public class ResultView {
    public static void printTickets(List<Ticket> ticketList) {
        for (Ticket ticket : ticketList) {
            System.out.println(ticket.numbers().numbers());
        }
        System.out.println();
    }

    public static void printResult(int countOfTicket, GameResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        int totalAmount = printMatches(result);
        double profitRate = (double) totalAmount / (countOfTicket * 1000);

        System.out.printf("총 수익률은 %.2f 입니다.", profitRate);
        printPerformance(profitRate);
    }

    private static int printMatches(GameResult result) {
        int totalAmount = 0;

        for (int rank = 5; rank >= 1; rank--) {
            int numberOfMatchedNumber = result.countOfMatchedNumberByRank(rank);
            int numberOfTickets = result.countOfTicketByRank(rank);
            int profit = new Profit(rank).value();
            totalAmount += numberOfTickets * profit;
            printMatch(rank, numberOfMatchedNumber,numberOfTickets, profit);
        }

        return totalAmount;
    }

    private static void printMatch(int rank, int matchedNumber, int numberOfTickets, int profit) {
        System.out.print(matchedNumber + "개 일치");
        if (rank == 2) {
            System.out.print(", 보너스 볼 일치");
        }

        System.out.println(" (" + profit + "원) - " + numberOfTickets + "개");
    }

    private static void printPerformance(double profitRate) {
        if (profitRate < 1) {
            printFinal("손해");
            return;
        }

        if (profitRate > 1) {
            printFinal("이익");
            return;
        }

        printFinal("본전");
    }

    private static void printFinal(String profitResult) {
        System.out.println("(기준이 1이기 때문에 결과적으로 " + profitResult + "라는 의미임)");
    }
}
