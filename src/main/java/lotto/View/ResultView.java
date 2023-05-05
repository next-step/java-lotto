package lotto.View;

import java.util.HashMap;
import java.util.List;

import lotto.Model.GameResult;
import lotto.Model.Profit;
import lotto.Model.Ticket;


public class ResultView {
    private static final int BONUS_CATEGORY = 15;
    private static final HashMap<Integer, Integer> RESULT_TABLE = new HashMap<>() {{
        put(1, 3);
        put(2, 4);
        put(3, 5);
        put(4, 15);
        put(5, 6);
    }};

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

        int totalAmount = printMatches(result.table());
        double profitRate = (double) totalAmount / (countOfTicket * 1000);

        System.out.printf("총 수익률은 %.2f 입니다.", profitRate);
        printPerformance(profitRate);
    }

    private static int printMatches(HashMap<Integer, Integer> result) {
        int totalAmount = 0;

        for (int printIndex = 1; printIndex <= 5; printIndex++) {
            int matchedNumber = RESULT_TABLE.get(printIndex);
            int numberOfTickets = result.get(matchedNumber);

            int profit = new Profit(matchedNumber).value();
            totalAmount += numberOfTickets * profit;
            printMatch(matchedNumber, numberOfTickets, profit);
        }

        return totalAmount;
    }

    private static void printMatch(int matchedNumber, int numberOfTickets, int profit) {
        if (BONUS_CATEGORY == matchedNumber) {
            System.out.println("5개 일치, 보너스 볼 일치 (" + profit + "원)- " + numberOfTickets + "개");
            return;
        }

        System.out.println(matchedNumber + "개 일치 (" + profit + "원)- " + numberOfTickets + "개");
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
