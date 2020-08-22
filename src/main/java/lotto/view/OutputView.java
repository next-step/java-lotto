package lotto.view;

import lotto.LottoMachine;
import lotto.LottoNumberMatcher;
import lotto.LottoSeller;
import lotto.LottoTicket;

import java.util.List;

public class OutputView {
    public static void printTicketCount(LottoSeller lottoSeller) {
        System.out.println(lottoSeller.getTicketCount() + "개를 구매했습니다.");

    }

    public static void printBuyingTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket.toString()));
    }

    public static void printResult(LottoNumberMatcher lottoNumberMatcher) {
    }

    public static void printProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }
}
