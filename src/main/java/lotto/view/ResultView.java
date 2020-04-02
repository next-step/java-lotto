package lotto.view;

import lotto.domain.item.LottoTicket;

public class ResultView {

    public static void printLoots(LottoDto dto) {
        System.out.println(dto.getTickets().size() + "개를 구매 했습니다.");
        for (LottoTicket lotto : dto.getTickets().getTickets()) {
            System.out.println(lotto);
        }
    }

    public static void printResult(LottoDto dto) {
        System.out.println("3개 일치 (5000원)- " + dto.getFifthGameCount() + "개");
        System.out.println("4개 일치 (50000원)- " + dto.getFourthGameCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + dto.getThirdGameCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + dto.getSecondGameCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + dto.getFirstGameCount() + "개");
    }

    public static void printEarningResult(LottoDto dto) {
        System.out.println("총 수익률은" + dto.getEarningRate() + "입니다.");
    }
}
