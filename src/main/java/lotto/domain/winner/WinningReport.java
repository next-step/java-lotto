package lotto.domain.winner;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.PurchasePrice;
import lotto.domain.TicketBox;
import lotto.domain.number.MatchResult;
import lotto.domain.number.Ticket;
import lotto.domain.number.WinningTicket;

public class WinningReport {

    private final Map<WinningCondition, Integer> report;

    public WinningReport() {
        report = new EnumMap<>(WinningCondition.class);
        for (WinningCondition condition : WinningCondition.values()) {
            report.put(condition, 0);
        }
    }

    public void updateReport(TicketBox ticketBox, WinningTicket winningNumbers) {
        for (Ticket ticket : ticketBox.getTickets()) {
            updateReport(winningNumbers.getMatchResult(ticket));
        }
    }

    public int getWinningCount(WinningCondition condition) {
        return report.get(condition);
    }

    public double getRateOfReturn(PurchasePrice purchasePrice) {
        return Math.floor((getSumOfPrize() / purchasePrice.getPrice()) * 100) / 100;
    }

    private void updateReport(MatchResult matchResult) {
        WinningCondition condition = WinningCondition.getConditionByMatchCount(
                matchResult.getMatchCount(), matchResult.getBonusMatch());
        int currentCount = report.get(condition);
        report.put(condition, currentCount + 1);
    }

    private double getSumOfPrize() {
        double sumOfPrize = 0;
        for (Map.Entry<WinningCondition, Integer> entry : report.entrySet()) {
            sumOfPrize += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return sumOfPrize;
    }

}
