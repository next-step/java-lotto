package edu.nextstep.lottobonusnumber.utils;

import edu.nextstep.lottobonusnumber.domain.Payment;
import edu.nextstep.lottobonusnumber.domain.Prize;

import java.util.Arrays;
import java.util.Map;

public class Calculator {

    public static double calculateRateOfReturn(Map<Prize, Integer> winningResult, Payment payment) {
        long totalWinningPrize = calculateWinningPrize(winningResult);
        int totalPayment = calculatePayment(payment);

        return (double) totalWinningPrize / totalPayment;
    }

    private static long calculateWinningPrize(Map<Prize, Integer> winningResult) {
        return Arrays.stream(Prize.values())
                .mapToLong(prize -> prize.calculatePrize(winningResult.get(prize)))
                .sum();
    }

    private static int calculatePayment(Payment payment) {
        return payment.countOfTickets() * Payment.TICKET_PRICE;
    }
}
