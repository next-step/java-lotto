package lotto.view;

import lotto.common.LottoRank;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoPack;

import java.util.Comparator;
import java.util.Map;

public class OutputView {

    // 유틸리티 성격을 가진 클래스이므로 묵시적인 생성자를 방지한다.
    private OutputView() {
    }

    public static void printBuyingTickets(LottoPack lottoPack) {
        printTicketCount(lottoPack);
        lottoPack.getLottoTickets()
                .forEach(System.out::println);
    }


    private static void printTicketCount(LottoPack lottoPack) {
        System.out.println(lottoPack.ticketCount() + "개를 구매했습니다.");
    }

    public static void printResult(LottoMatchResult lottoMatchResult) {
        System.out.println("당첨 통계\n---------");
        Map<LottoRank, Integer> matchResult = lottoMatchResult.getMatchResult();

        matchResult.keySet().stream()
                .filter(lottoRank -> !LottoRank.MISS.equals(lottoRank))
                .sorted(Comparator.comparing(LottoRank::getMatchCount))
                .forEachOrdered(rank -> printMatchResult(rank, matchResult.get(rank)));

        printProfit(lottoMatchResult.getProfit());
    }

    private static void printMatchResult(LottoRank rank, int matchTicketCount) {
        String message = rank.getMatchCount() + "개 일치(" + rank.getReward() + "원) - "
                + matchTicketCount + "개";
        System.out.println(message);
    }

    private static void printProfit(double profit) {
        String message = "총 수익률은 " + profit + "입니다.";

        if (profit < 1) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        System.out.println(message);
    }
}
