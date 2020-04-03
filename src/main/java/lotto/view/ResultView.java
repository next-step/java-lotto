package lotto.view;

import lotto.domain.item.LottoTicket;

public class ResultView {

    private static final String BUY_COUNT_MESSAGE = "수동으로 %s장, 자동으로 %s장을 구매 했습니다.";

    public static void printLottoBuyCount(int pass, int auto) {
        System.out.println(String.format(BUY_COUNT_MESSAGE, pass, auto));
    }

    public static void printLoots(MatchedLottoDto dto) {
        for (LottoTicket lotto : dto.getTickets().getTickets()) {
            System.out.println(lotto);
        }
    }

    public static void printResult(MatchedLottoDto dto) {
        System.out.println("3개 일치 (5000원)- " + dto.getFifthGameCount() + "개");
        System.out.println("4개 일치 (50000원)- " + dto.getFourthGameCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + dto.getThirdGameCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + dto.getSecondGameCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + dto.getFirstGameCount() + "개");
    }

    public static void printEarningResult(MatchedLottoDto dto) {
        System.out.println("총 수익률은" + dto.getEarningRate() + "입니다.");
    }
}
