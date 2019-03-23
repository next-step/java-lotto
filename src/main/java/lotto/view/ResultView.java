package lotto.view;

public class ResultView {
    public void printPurchaseTicketCount(int tickets) {
        System.out.println(String.format("%s를 구매했습니다.", tickets));
        System.out.println("[8, 21, 23, 42, 42]");
    }

    public void winningNumberStatistics() {
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println(perStatistics(3, 5000, 1));
        System.out.println(perStatistics(4, 50000, 0));
        System.out.println(perStatistics(5, 1500000, 0));
        System.out.println(perStatistics(6, 2000000000, 0));
    }

    public String perStatistics(int matchedNumber, int winningAmount, int winningNumber) {
        return String.format("%d개 일치(%d원)- %d개", matchedNumber, winningAmount, winningNumber);
    }

    public void revenueRate(double rate) {
        String benefitResult = rate >= 1 ? "이득이" : "손해";
        System.out.println(String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", String.valueOf(rate), benefitResult));
    }
}
