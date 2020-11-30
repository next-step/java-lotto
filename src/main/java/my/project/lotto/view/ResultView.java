package my.project.lotto.view;


import my.project.lotto.domain.Rank;
import my.project.lotto.domain.WinningLotto;
import my.project.lotto.dto.Lottos;
import my.project.lotto.dto.ManualCount;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {
    public static final String MANUAL_PURCHARED = "수동으로 ";
    public static final String AUTO_PURCHARED = "자동으로 ";
    public static final String PURCHASED = "를 구매했습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String DIVIDE = "---------";
    public static final String FIFTH_PRIZE = "3개 일치 (" + Rank.FIFTH.getPrize() + "원)- ";
    public static final String FOURTH_PRIZE = "4개 일치 (" + Rank.FOURTH.getPrize() + "원)- ";
    public static final String THIRD_PRIZE = "5개 일치 (" + Rank.THIRD.getPrize() + "원)- ";
    public static final String SECOND_PRIZE = "5개 일치, 보너스 볼 일치 (" + Rank.SECOND.getPrize() + "원)- ";
    public static final String FIRST_PRIZE = "6개 일치 (" + Rank.FIRST.getPrize() + "원)- ";
    public static final String UNIT = "개";
    public static final String PROFIT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String COMMA = ", ";

    public static void printLottos(Lottos lottos, ManualCount manualCount) {
        printPurchagedLotto(lottos, manualCount);
        printLotto(lottos);
    }

    private static void printPurchagedLotto(Lottos lottos, ManualCount manualCount) {
        System.out.println(MANUAL_PURCHARED + manualCount.getManualCount() + UNIT
                + COMMA + AUTO_PURCHARED + (lottos.size() - manualCount.getManualCount()) + UNIT + PURCHASED);
    }

    private static void printLotto(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.toNumbers()));
    }

    public static void printRanks(WinningLotto winningLotto) {
        System.out.println("\n" + WINNING_STATISTICS);
        System.out.println(DIVIDE);
        System.out.println(FIFTH_PRIZE + winningLotto.countFifthRanks() + UNIT);
        System.out.println(FOURTH_PRIZE + winningLotto.countFourthRanks() + UNIT);
        System.out.println(THIRD_PRIZE + winningLotto.countThirdRanks() + UNIT);
        System.out.println(SECOND_PRIZE + winningLotto.countSecondRanks() + UNIT);
        System.out.println(FIRST_PRIZE + winningLotto.countFirstRanks() + UNIT);
        System.out.println(String.format(PROFIT, winningLotto.profit()));
    }

    private ResultView() {
    }
}
