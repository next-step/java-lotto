package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoReport {
    private static final int CASH_PRIZE_COLLECT_3 = 5000;
    private static final int CASH_PRIZE_COLLECT_4 = 50000;
    private static final int CASH_PRIZE_COLLECT_5 = 1500000;
    private static final int CASH_PRIZE_COLLECT_6 = 2000000000;

    private final List<Integer> result;
    private final double rateOfReturn;

    public LottoReport(String winningNumber, List<Lotto> tickets) {
        this.result = new ArrayList<>(Collections.nCopies(7, 0));
        for (Lotto ticket : tickets) {
            addResult(winningNumber, ticket);
        }
        this.rateOfReturn = calculateRateOfReturn();
    }

    public LottoReport(List<Integer> result) {
        this.result = result;
        this.rateOfReturn = calculateRateOfReturn();
    }

    private static List<Integer> convertStringToInt(String numbers) {
        return Arrays.stream(numbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void addResult(String number, Lotto ticket) {
        int matchCount = ticket.matchNumbers(convertStringToInt(number));
        this.result.set(matchCount, this.result.get(matchCount) + 1);
    }

    private double calculateRateOfReturn() {
        return Math.floor(calculateTotalCashPrize() / calculateTotalInvestment() * 100) / 100;
    }

    private double calculateTotalCashPrize() {
        return this.result.get(3) * CASH_PRIZE_COLLECT_3
                + this.result.get(4) * CASH_PRIZE_COLLECT_4
                + this.result.get(5) * CASH_PRIZE_COLLECT_5
                + this.result.get(6) * CASH_PRIZE_COLLECT_6;
    }

    private double calculateTotalInvestment() {
        int ticketCount = this.result.stream()
                .mapToInt(Integer::intValue)
                .sum();
        return ticketCount * LottoMachine.ticketPrice();
    }

    public List<Integer> result() {
        return this.result;
    }

    public double rateOfReturn() {
        return this.rateOfReturn;
    }

}
