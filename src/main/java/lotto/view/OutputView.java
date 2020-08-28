package lotto.view;

import lotto.*;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    // 유틸리티 성격을 가진 클래스이므로 묵시적인 생성자를 방지한다.
    private OutputView() {
    }

    public static void printTicketCount(LottoSeller lottoSeller) {
        System.out.println(lottoSeller.getTicketCount() + "개를 구매했습니다.");
    }

    public static void printBuyingTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket.toString()));
    }

    public static void printResult(LottoNumberMatcher lottoNumberMatcher) {
        System.out.println("당첨 통계\n---------");
        Arrays.stream(LottoPriceInfo.values())
                .forEach(info -> {
                    String matchResultMessage = info.getMatchResultMessage(lottoNumberMatcher);
                    System.out.println(matchResultMessage);
                });
    }

    public static void printProfit(double profit) {
        String message = "총 수익률은 " + profit + "입니다.";

        if (profit < 1) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        System.out.println(message);
    }
}
