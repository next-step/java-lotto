package lotto.view;

import lotto.domain.item.LottoTicket;

public class ResultView {

    private static final String BUY_COUNT_MESSAGE = "수동으로 %s장, 자동으로 %s장을 구매 했습니다.";
    private static final String FIFTH_MESSAGE = "3개 일치 (5000원)- %s개";
    private static final String FOURTH_MESSAGE = "4개 일치 (50000원)- %s개";
    private static final String THIRD_MESSAGE = "5개 일치 (1500000)- %s개";
    private static final String SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30000000원)- %s개";
    private static final String FIRST_MESSAGE = "6개 일치 (2000000000원)- %s개";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %S입니다";


    public static void printLottoBuyCount(int pass, int auto) {
        System.out.println(String.format(BUY_COUNT_MESSAGE, pass, auto));
    }

    public static void printLoots(MatchedLottoDto dto) {
        for (LottoTicket lotto : dto.getTickets().getTickets()) {
            System.out.println(lotto);
        }
    }

    public static void printResult(MatchedLottoDto dto) {
        System.out.println(String.format(FIFTH_MESSAGE, dto.getFifthGameCount()));
        System.out.println(String.format(FOURTH_MESSAGE, dto.getFourthGameCount()));
        System.out.println(String.format(THIRD_MESSAGE, dto.getThirdGameCount()));
        System.out.println(String.format(SECOND_MESSAGE, dto.getSecondGameCount()));
        System.out.println(String.format(FIRST_MESSAGE, dto.getFirstGameCount()));
    }

    public static void printEarningResult(MatchedLottoDto dto) {
        System.out.println(String.format(EARNING_RATE_MESSAGE, dto.getEarningRate()));
    }
}
