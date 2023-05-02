package lotto.View;

import java.util.HashMap;
import java.util.List;

import lotto.Model.Profit;
import lotto.Model.Ticket;


public class ResultView {
    public static void printTickets(List<Ticket> ticketList) {
        for (Ticket ticket : ticketList) {
            System.out.println(ticket.numbers().numbers());
        }
        System.out.println();
    }

    public static void printResult(int countOfTicket, HashMap<Integer, Integer> result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        int totalAmount = printMatches(result);
        double profitRate = (double) totalAmount / (countOfTicket * 1000);

        System.out.printf("총 수익률은 %.2f 입니다.", profitRate);
        printPerformance(profitRate);
    }

    private static int printMatches(HashMap<Integer, Integer> result) {
        int totalAmount = 0;

        for (int i = 3; i <= 6; i++) {
            int profit = new Profit(i).value();
            int count = result.get(i);
            totalAmount += count * profit;
            System.out.println(i + "개 일치 (" + profit + "원)- " + count + "개");
        }

        return totalAmount;
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
        System.out.println("(기준이 1이기 때문에 결과적으로 "+profitResult+"라는 의미임)");
    }
}
