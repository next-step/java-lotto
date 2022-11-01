package lotto.view;

import lotto.domain.LottoEarningCalculator;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultView {
    public static void printTickets(List<LottoTicket> ticketList) {
        System.out.println(ticketList.size() + "개를 구매했습니다.");
        for (LottoTicket ticket : ticketList) {
            System.out.println(ticket);
        }
    }

    public static void printResult(List<LottoPrize> prizeList, int numberOfTickets) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<LottoPrize> ascendingOrderedLottoPrizeList = Arrays.stream(LottoPrize.values())
                .sorted(Comparator.comparingInt(LottoPrize::getReward))
                .collect(Collectors.toList());

        for (LottoPrize prize : ascendingOrderedLottoPrizeList) {
            String prizeInfo = prize.getWinningConditionCommonNumberCount() + "개 일치 (" + prize.getReward() + ")";
            long prizeCount = prizeList.stream().filter(p -> p == prize).count();
            System.out.println(prizeInfo + " - " + prizeCount + "개");
        }

        float earningRate = LottoEarningCalculator.calculateEarningRate(prizeList, numberOfTickets);
        System.out.println("총 수익률은 " + earningRate + "입니다.");
    }
}
