package lotto.view;

import lotto.domain.item.LottoTicket;

import java.util.List;

public class ResultView {

    public static void printLoots(List<LottoTicket> lottos) {
        System.out.println(lottos.size() + "개를 구매 했습니다.");
        for (LottoTicket lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printLuckyNumber(List<Integer> luckyNumber) {
        System.out.println(luckyNumber);
    }

    public static void printResult(StatisticDataDto dto) {
        System.out.println("3개 일치 (5000원)- " + dto.getMatchCount3() + "개");
        System.out.println("4개 일치 (50000원)- " + dto.getMatchCount4() + "개");
        System.out.println("5개 일치 (150000원)- " + dto.getMatchCount5() + "개");
        System.out.println("6개 일치 (2000000000)- " + dto.getMatchCount6() + "개");
    }
}
