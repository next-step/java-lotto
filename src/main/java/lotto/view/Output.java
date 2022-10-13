package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

import java.util.List;

public class Output {

    private final static String ENTER = System.lineSeparator();
    private final static String LOTTO_BUY = "%d개 구매되었습니다.";
    private final static String LOTTO_RESULT = "== 로또 당첨 결과 ==";
    private final static String LOTTO_STATS_RANK = "%d개 일치 (%d원) - %d개";
    private final static String LOTTO_RETURN_INVESTMENT = "총 수익률은 %f 입니다.";

    private Output() {
    }

    public static void printBuyCount(final int buyCount) {
        StringBuilder print = new StringBuilder(ENTER)
                .append(String.format(LOTTO_BUY, buyCount));
        System.out.println(print);
    }

    public static void printBuyTickets(final List<Lotto> lottoTickets) {
        StringBuilder print = new StringBuilder();
        for (Lotto lotto : lottoTickets) {
            print.append(lotto.lottoNumber().toString()).append(ENTER);
        }
        System.out.println(print);
    }

    public static void printLottoResult(final List<Integer> lottoResult) {
        StringBuilder print = new StringBuilder(LOTTO_RESULT).append(ENTER);
        for (int i = 0; i < lottoResult.size(); i++) {
            print.append(String.format(LOTTO_STATS_RANK
                    , LottoPrize.values()[i].matchCount()
                    , LottoPrize.values()[i].amount()
                    , lottoResult.get(i)))
                    .append(ENTER);
        }
        System.out.println(print);
    }

    public static void printReturnOnInvestment(final double returnOnInvestment) {
        System.out.println(String.format(LOTTO_RETURN_INVESTMENT
                , returnOnInvestment));
    }
}
