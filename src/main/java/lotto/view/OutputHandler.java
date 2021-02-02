package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Constant;
import lotto.domain.Revenue;
import lotto.domain.Ticket;
import lotto.util.NumberUtils;

public class OutputHandler {

    public void printLottoPurchaseCount(int count) {
        System.out.println(createLottoPurchaseCountString(count));
    }

    public void printGeneratedTickets(List<Ticket> tickets) {
        System.out.println(createGeneratedTicketsString(tickets));
    }

    public void printLottoStatics(Map<Revenue, Integer> revenueMap) {
        System.out.println(createLottoStaticsString(revenueMap));
    }

    public void printTotalRevenue(Double totalRevenue) {
        System.out.println(createTotalRevenueString(totalRevenue));
    }

    public void printErrorPurchasePrice() {
        System.out.println(Constant.ERROR_PURCHASE_PRICE);
    }

    public void printErrorBonusBall() {
        System.out.println(Constant.ERROR_BONUS_BALL);
    }

    public void printErrorWinningNumber() {
        System.out.println(Constant.ERROR_WINNING_NUMBER);
    }

    private StringBuilder createLottoPurchaseCountString(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(count).append(Constant.REMIND_LOTTO_COUNT);
    }

    private StringBuilder createGeneratedTicketsString(List<Ticket> tickets) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Ticket ticket : tickets) {
            stringBuilder.append(ticket.toString());
            stringBuilder.append(Constant.LINE_BREAK);
        }
        return stringBuilder;
    }

    private StringBuilder createLottoStaticsString(Map<Revenue, Integer> revenueCluster) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(Constant.WINNING_STATISTICS).append(Constant.DIVISION_LINE)
            .append(createLottoResultString(revenueCluster, stringBuilder));
    }

    private StringBuilder createLottoResultString(Map<Revenue, Integer> revenueCluster,
        StringBuilder stringBuilder) {
        Arrays.stream(Revenue.values()).filter(revenue -> revenue != Revenue.NOTHING)
            .forEach(revenue -> {
                stringBuilder.append(revenue.getMatchNum())
                    .append(appendBonusNumber(revenue.getBonus()))
                    .append(Constant.CORRECT_NUM).append(Constant.OPEN_BRACKET)
                    .append(revenue.getRevenue()).append(Constant.MONEY_UNIT)
                    .append(NumberUtils.convertNullToNumber(revenueCluster.get(revenue)))
                    .append(Constant.COUNT);
            });
        return stringBuilder;
    }

    private StringBuilder createTotalRevenueString(Double totalRevenue) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(Constant.TOTAL_YIELD)
            .append(totalRevenue)
            .append(Constant.END_SENTENCE)
            .append(isIncome(totalRevenue));
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
