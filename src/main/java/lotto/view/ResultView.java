package lotto.view;

import lotto.domain.item.LottoTicket;

public class ResultView {

    public static void printLoots(LottoDto dto) {
        System.out.println(dto.getTickets().size() + "개를 구매 했습니다.");
        for (LottoTicket lotto : dto.getTickets()) {
            System.out.println(lotto);
        }
    }

    public static void printResult(LottoDto dto) {
        System.out.println("3개 일치 (5000원)- " + dto.getFirstGameCount() + "개");
        System.out.println("4개 일치 (50000원)- " + dto.getSecondGameCount() + "개");
        System.out.println("5개 일치 (150000원)- " + dto.getThirdGameCount() + "개");
        System.out.println("6개 일치 (2000000000)- " + dto.getFourthGameCount() + "개");
//        System.out.println("총 수익률은" + dto.getEarningRate() + "입니다.");
    }

    public static void printEarningResult(LottoDto dto) {
        System.out.println("총 수익률은" + dto.getEarningRate() + "입니다.");
    }
}
