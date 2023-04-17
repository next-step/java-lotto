package view;

import lotto.LottoTicket;
import lotto.LottoType;
import lotto.ManyTickets;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoOutput {

    public void printTickets(ManyTickets tickets) {
        tickets.getManyTickets().forEach(ticket -> System.out.println(ticket.toString()));
    }

    public void printWinningList(Map<LottoType, Long> winningResult) {
        System.out.println("당첨 통계");
        winningResult.forEach((key, value) -> System.out.println(key.getPrintString() + "- " + value + "개"));
    }

    public void printRate(BigDecimal rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }


}
