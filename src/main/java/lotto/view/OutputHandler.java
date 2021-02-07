package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Constant;
import lotto.domain.Revenue;
import lotto.domain.Ticket;
import lotto.util.NumberUtils;

public class OutputHandler {

    public void printLottoPurchaseCount(int manualCounts, int autoCounts) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualCounts, autoCounts);
    }

    public void printGeneratedTickets(List<Ticket> tickets) {
        System.out.println(createGeneratedTicketsString(tickets));
    }

    public void printLottoStatics(Map<Revenue, Integer> revenueMap) {
        System.out.println(Constant.WINNING_STATISTICS + Constant.DIVISION_LINE);
        Arrays.stream(Revenue.values()).forEach(revenue ->
                System.out.printf("%d개 일치%s (%d원) - %d개%n",
                revenue.getMatchNum(),
                appendBonusNumber(revenue.getBonus()),
                revenue.getRevenue(),
                NumberUtils.convertNullToNumber(revenueMap.get(revenue))));
    }

    public void askLottoTicket() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public void printTotalRevenue(Double totalRevenue) {
        System.out.printf("총 수익률은 %s입니다. %s", totalRevenue.toString(), isIncome(totalRevenue));
    }

    public void printErrorPurchasePrice() {
        System.out.println(Constant.ERROR_PURCHASE_PRICE);
    }

    public void printErrorBonusBall() {
        System.out.println(Constant.ERROR_BONUS_BALL);
    }

    public void printErrorTicketNumber() {
        System.out.println(Constant.ERROR_WINNING_NUMBER);
    }

    public void printErrorManualTicketCount() {
        System.out.println(Constant.ERROR_MANUAL_COUNT);
    }

    private StringBuilder createGeneratedTicketsString(List<Ticket> tickets) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Ticket ticket : tickets) {
            stringBuilder.append(ticket.toString());
            stringBuilder.append('\n');
        }
        return stringBuilder;
    }

    private String isIncome(Double totalRevenue) {
        if (totalRevenue > 1) {
            return Constant.TOTAL_YIELD_RESULT_INCOME;
        }
        return Constant.TOTAL_YIELD_RESULT_LOSS;
    }

    private String appendBonusNumber(boolean bonus) {
        if (bonus) {
            return Constant.BONUS;
        }
        return "";
    }
}
