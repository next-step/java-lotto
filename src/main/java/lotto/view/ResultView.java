package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.ticket.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;


public class ResultView {
    private final static List<String> STATISTICS__WINNER_LIST_SENTENCE = List.of("3개 일치 (5000원) - ", "4개 일치 (50000원) - ", "5개 일치 (1500000) - ", "6개 일치 (2000000000) - ");
    private final static String ALL_RATIO_SENTENCE = "총 수익률은 ";
    private final static String PURCHASE_SENTENCE = "개를 구매했습니다.";
    private final static String WINNER_STATISTICS = "당첨 통계\n---------\n";

    public static void purchaseResultView(int purchaseLottoCount) {
        purchaseSentence(purchaseLottoCount);
    }

    public static void getLottoNumbersSentence(Lotto lotto) {
        System.out.println();
        String result = lotto.getLottoTickets().stream()
                .map(ticket -> "[" + String.join(", ", ticket.displayNumbers()) + "]")
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }

    public static void purchaseSentence(int purchaseLottoCount) {
        System.out.println(purchaseLottoCount + PURCHASE_SENTENCE);
    }

    public static void statisticsResultView(double ratio) {
        System.out.println(ALL_RATIO_SENTENCE + ratio + "입니다.");
    }

    public static void prizeResultView(List<Integer> prizeCounts) {
        System.out.println();
        System.out.println(WINNER_STATISTICS);
        for (int i = 0; i < prizeCounts.size(); i++) {
            System.out.println(STATISTICS__WINNER_LIST_SENTENCE.get(i) + prizeCounts.get(i));
        }
    }

}
