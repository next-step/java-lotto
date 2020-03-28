package lotto.view;

import lotto.domain.item.LottoTicket;

import java.util.List;

public class ResultView {

    public static void printLoots(LottoDto dto) {
        System.out.println(dto.getTickets().size() + "개를 구매 했습니다.");
        for (LottoTicket lotto : dto.getTickets()) {
            System.out.println(lotto);
        }
    }

    public static void printLuckyNumber(List<Integer> luckyNumber) {
        System.out.println(luckyNumber);
    }

    public static void printResult(LottoDto dto) {
        System.out.println("3개 일치 (5000원)- " + dto.getMatch3GameCount() + "개");
        System.out.println("4개 일치 (50000원)- " + dto.getMatch4GameCount() + "개");
        System.out.println("5개 일치 (150000원)- " + dto.getMatch5GameCount() + "개");
        System.out.println("6개 일치 (2000000000)- " + dto.getMatch6GameCount() + "개");
//        System.out.println("총 수익률은" + dto.getEarningRate() + "입니다.");
    }
}
