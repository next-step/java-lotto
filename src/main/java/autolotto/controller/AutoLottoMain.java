package autolotto.controller;

import autolotto.domain.LottoStatistics;
import autolotto.strategy.LottoNumberGenerator;
import autolotto.strategy.LottoNumberGeneratorImpl;
import autolotto.ui.InputView;
import autolotto.ui.OutputView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoMain {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBERS_PER_TICKET = 6;

    public static void main(String[] args) {
        int amount = InputView.buyAmt();
        int ticketsCount = amount / LOTTO_PRICE;
        System.out.println(ticketsCount + "개를 구매했습니다.");

        LottoNumberGenerator generator = new LottoNumberGeneratorImpl();
        List<List<Integer>> tickets = IntStream.range(0, ticketsCount)
                .mapToObj(i -> generator.generateNumbers())
                .collect(Collectors.toList());

        OutputView.printLottoNumber(tickets);
        List<Integer> lastWeekWinNumber = InputView.lastWeekWinNumber();

        // 당첨 통계 계산
        int[] matchCounts = new int[NUMBERS_PER_TICKET + 1];
        for (List<Integer> ticket : tickets) {
            int matchCount = 0;
            for (int number : ticket) {
                if (lastWeekWinNumber.contains(number)) {
                    matchCount++;
                }
            }
            matchCounts[matchCount]++;
        }

        LottoStatistics lottoStatistics = new LottoStatistics(matchCounts, ticketsCount);
        // 수익률 계산 및 출력
        double profit = lottoStatistics.calculateProfit(matchCounts, ticketsCount);
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n", profit);
    }
}