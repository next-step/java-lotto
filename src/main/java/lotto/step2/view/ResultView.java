package lotto.step2.view;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.Rank;
import lotto.step2.domain.WinningStatistics;
import java.util.List;

public class ResultView {

    private final static String MESSAGE_PURCHASING_COUNT = "개를 구입하셨습니다.";
    private final static String MESSAGE_WINNING_RESULT = "당첨 통계\n--------";
    private final static String MESSAGE_NUMBER_MATCHED= "개 일치 (";
    private final static String MESSAGE_WON= "원)- ";
    private final static String MESSAGE_COUNT= "개";
    private final static String MESSAGE_TOTAL_PROFITS= "총 수익률은 ";
    private final static String MESSAGE_IS= "입니다.";

    private ResultView(){
    }
    
    public static void printPurchasingCount(int count) {
        System.out.println(count + MESSAGE_PURCHASING_COUNT);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream()
                .forEach(lotto -> System.out.println(lotto.lottoNumbers()));
        System.out.println();
    }

    public static void printResult(WinningStatistics winningStatistics) {
        System.out.println(MESSAGE_WINNING_RESULT);
        for(Rank rank : winningStatistics.statistics().keySet()) {
            System.out.println(rank.hit() + MESSAGE_NUMBER_MATCHED + rank.amount() + MESSAGE_WON + winningStatistics.statistics().get(rank) + MESSAGE_COUNT);
        }
    }

    public static void printProfits(WinningStatistics winningStatistics) {
        System.out.println(MESSAGE_TOTAL_PROFITS +  winningStatistics.profits() + MESSAGE_IS);
    }

}

