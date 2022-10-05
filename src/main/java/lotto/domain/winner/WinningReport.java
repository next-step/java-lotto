package lotto.domain.winner;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.LottoMachine;
import lotto.domain.TicketBox;
import lotto.domain.exception.InvalidPurchasePriceException;
import lotto.domain.number.WinningNumbers;

public class WinningReport {

    private final Map<WinningCondition, Integer> report;

    public WinningReport() {
        report = new EnumMap<>(WinningCondition.class);
        for (WinningCondition condition : WinningCondition.values()) {
            report.put(condition, 0);
        }
    }

    public void updateReport(TicketBox ticketBox, WinningNumbers winningNumbers) {
        for (int i = 0; i < ticketBox.getSize(); i++) {
            updateReport(
                    LottoMachine.getMatchingNumberCount(winningNumbers, ticketBox.getTicket(i)));
        }
    }

    public int getWinningCount(WinningCondition condition) {
        return report.get(condition);
    }

    public double getRateOfReturn(int purchasePrice) {
        if (purchasePrice <= 0) {
            throw new InvalidPurchasePriceException();
        }

        return Math.floor((getSumOfPrize() / purchasePrice) * 100) / 100;
    }

    private void updateReport(int matchCount) {
        WinningCondition condition = WinningCondition.getConditionByMatchCount(matchCount);
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
