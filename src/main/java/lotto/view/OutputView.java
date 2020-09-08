package lotto.view;

import lotto.common.LottoPriceInfo;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoPackage;

import java.util.Arrays;

public class OutputView {

    // 유틸리티 성격을 가진 클래스이므로 묵시적인 생성자를 방지한다.
    private OutputView() {
    }

    public static void printBuyingTickets(LottoPackage lottoPackage) {
        printTicketCount(lottoPackage);
        lottoPackage.getLottoTickets()
                .forEach(System.out::println);
    }


    private static void printTicketCount(LottoPackage lottoPack) {
        System.out.println(lottoPack.getTicketCount() + "개를 구매했습니다.");
    }

    public static void printResult(LottoMatchResult lottoMatchResult) {
        System.out.println("당첨 통계\n---------");
        Arrays.stream(LottoPriceInfo.values())
                .filter(p1 -> !p1.equals(LottoPriceInfo.LOTTO_RANK_0))
                .forEachOrdered(p1 -> {
                    Long matchTicketCount = lottoMatchResult.matchCount(p1);
                    String message = p1.getMatchCount() + "개 일치(" + p1.getPrice() + "원) - "
                            + matchTicketCount + "개";
                    System.out.println(message);
                });

        printProfit(lottoMatchResult.getProfit());
    }

    private static void printProfit(double profit) {
        String message = "총 수익률은 " + profit + "입니다.";

        if (profit < 1) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        System.out.println(message);
    }
}
