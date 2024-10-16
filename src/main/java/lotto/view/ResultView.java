package lotto.view;

import lotto.domain.Prize;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.ticket.LottoTicket;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ResultView {
    private final static List<Prize> PRIZE_LIST = List.of(Prize.FIFTH, Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST);
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

    public static void prizeResultView(Map<Prize,Integer> prizes) {
        System.out.println(WINNER_STATISTICS);
        for(Prize prize : PRIZE_LIST){
            System.out.println(prize.getMessage() + prizes.get(prize) + "개");
        }
    }

}
