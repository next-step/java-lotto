package step2.view;

import step2.domain.LottoResult;
import step2.domain.LottoTicket;

import java.util.List;

public class OutputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String MATCH_RESULT_FORMAT = "%d개 일치 (%d)원 - %d 개";
    private static final String RATE_RESULT = "총 수익률은 %.2f입니다.";

    public static int getPurchaseAmount(int money) {
        int amount = money / LOTTO_PRICE;
        System.out.println(amount + "개 구매하였습니다.");
        return amount;
    }

    public static void showBuyTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.toString());
    }

    public static void showResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        showBoard(lottoResult);
        showRate(lottoResult);
    }

    private static void showBoard(LottoResult lottoResult) {
        lottoResult.getResult()
                .forEach((key, value) -> System.out.println(String.format(MATCH_RESULT_FORMAT, key.getMatchAmount(), key.getPrice(), value)));
    }

    private static void showRate(LottoResult lottoResult) {
        System.out.println(String.format(RATE_RESULT, lottoResult.getRate()));
    }
}
